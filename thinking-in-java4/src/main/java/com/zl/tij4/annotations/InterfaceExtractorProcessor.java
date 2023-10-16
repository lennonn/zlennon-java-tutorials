package com.zl.tij4.annotations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashSet;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("annotations.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class InterfaceExtractorProcessor extends AbstractProcessor {

  private Elements elementUtils;
  private Filer filer;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    elementUtils = processingEnv.getElementUtils();
    filer = processingEnv.getFiler();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    Set<ExecutableElement> interfaceMethods = new HashSet<>();

    for (Element element : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
      if (element.getKind() == ElementKind.CLASS) {
        TypeElement typeElement = (TypeElement) element;
        ExtractInterface annot = typeElement.getAnnotation(ExtractInterface.class);

        for (Element enclosedElement : typeElement.getEnclosedElements()) {
          if (enclosedElement.getKind() == ElementKind.METHOD) {
            ExecutableElement methodElement = (ExecutableElement) enclosedElement;

            if (methodElement.getModifiers().contains(Modifier.PUBLIC) &&
                    !methodElement.getModifiers().contains(Modifier.STATIC)) {
              interfaceMethods.add(methodElement);
            }
          }
        }

        if (!interfaceMethods.isEmpty()) {
          generateInterfaceFile(annot.value(), typeElement, interfaceMethods);
        }
      }
    }

    return true;
  }

  private void generateInterfaceFile(String interfaceName, TypeElement typeElement, Set<ExecutableElement> methods) {
    try {
      JavaFileObject sourceFile = filer.createSourceFile(interfaceName);

      try (PrintWriter writer = new PrintWriter(sourceFile.openWriter())) {
        Name packageName = elementUtils.getPackageOf(typeElement).getQualifiedName();

        writer.println("package " + packageName + ";");
        writer.println("public interface " + interfaceName + " {");

        for (ExecutableElement method : methods) {
          writer.print("  public ");
          writer.print(method.getReturnType() + " ");
          writer.print(method.getSimpleName() + "(");
          int paramCount = 0;

          for (javax.lang.model.element.VariableElement param : method.getParameters()) {
            writer.print(param.asType() + " " + param.getSimpleName());
            if (++paramCount < method.getParameters().size()) {
              writer.print(", ");
            }
          }

          writer.println(");");
        }

        writer.println("}");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
