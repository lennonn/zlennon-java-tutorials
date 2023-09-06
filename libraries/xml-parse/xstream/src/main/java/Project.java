import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@XStreamAlias("project")
public class Project {
    private  String modelVersion;

    @XStreamAlias("parent")

    private  Parent parent;

    private String  artifactId;
    private String  packaging;

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    @Override
    public String toString() {
        return "Project{" +
                "modelVersion='" + modelVersion + '\'' +
                ", parent=" + parent +
                ", artifactId='" + artifactId + '\'' +
                ", packaging='" + packaging + '\'' +
                '}';
    }
}
