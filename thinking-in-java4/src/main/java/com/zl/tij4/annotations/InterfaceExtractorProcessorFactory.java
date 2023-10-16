package com.zl.tij4.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes("annotations.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class InterfaceExtractorProcessorFactory extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element element : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
      if (element instanceof TypeElement) {
        TypeElement typeElement = (TypeElement) element;
        String interfaceName = typeElement.getAnnotation(ExtractInterface.class).value();
        try {
          generateInterfaceFile(typeElement, interfaceName);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return true;
  }

  private void generateInterfaceFile(TypeElement typeElement, String interfaceName) throws IOException {
    String packageName = processingEnv.getElementUtils().getPackageOf(typeElement).getQualifiedName().toString();
    String className = typeElement.getSimpleName().toString();
    String fileName = interfaceName + ".java";

    JavaFileObject fileObject = processingEnv.getFiler().createSourceFile(packageName + "." + interfaceName);
    try (Writer writer = fileObject.openWriter()) {
      writer.write("package " + packageName + ";\n");
      writer.write("public interface " + interfaceName + " {\n");

      for (Element enclosedElement : typeElement.getEnclosedElements()) {
        if (enclosedElement.getKind().isField() || enclosedElement.getKind() == ElementKind.METHOD) {
          writer.write("    ");
          writer.write(enclosedElement.asType() + " " + enclosedElement.getSimpleName() + "();\n");
        }
      }

      writer.write("}\n");
    }
  }
}


