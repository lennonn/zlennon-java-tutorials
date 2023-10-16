package com.zl.tij4.annotations.database;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.JavaFileObject;
import javax.lang.model.type.DeclaredType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.List;

@SupportedAnnotationTypes({
        "annotations.database.DBTable",
        "annotations.database.Constraints",
        "annotations.database.SQLString",
        "annotations.database.SQLInteger"
})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TableCreationProcessorFactory extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element element : roundEnv.getElementsAnnotatedWith(DBTable.class)) {
      if (element.getKind() == ElementKind.CLASS) {
        generateTableCreation((TypeElement) element);
      }
    }
    return true;
  }

  private void generateTableCreation(TypeElement classElement) {
    String packageName = processingEnv.getElementUtils().getPackageOf(classElement).getQualifiedName().toString();
    String className = classElement.getSimpleName().toString();

    try {
      JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(packageName + "." + className + "Table");
      try (PrintWriter writer = new PrintWriter(sourceFile.openWriter())) {
        writer.println("package " + packageName + ";");
        writer.println("public class " + className + "Table {");

        for (Element enclosedElement : classElement.getEnclosedElements()) {
          if (enclosedElement.getKind() == ElementKind.FIELD) {
            generateColumnDefinition(writer, (VariableElement) enclosedElement);
          }
        }

        writer.println("}");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void generateColumnDefinition(PrintWriter writer, VariableElement fieldElement) {
    String columnName = fieldElement.getSimpleName().toString();
    String columnDefinition = "VARCHAR(255)";

    if (fieldElement.getAnnotation(SQLInteger.class) != null) {
      SQLInteger sqlInteger = fieldElement.getAnnotation(SQLInteger.class);
      columnDefinition = "INT" + getConstraints(sqlInteger.constraints());
    } else if (fieldElement.getAnnotation(SQLString.class) != null) {
      SQLString sqlString = fieldElement.getAnnotation(SQLString.class);
      columnDefinition = "VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraints());
    }

    writer.println("    private " + columnDefinition + " " + columnName + ";");
  }

  private String getConstraints(Constraints con) {
    StringBuilder constraints = new StringBuilder();
    if (!con.allowNull()) {
      constraints.append(" NOT NULL");
    }
    if (con.primaryKey()) {
      constraints.append(" PRIMARY KEY");
    }
    if (con.unique()) {
      constraints.append(" UNIQUE");
    }
    return constraints.toString();
  }
}
