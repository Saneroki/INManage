package gen.java.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.io.Serializable;

/**
 * AddTaskObject
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-17T13:13:02.559Z")
public class AddTaskObject implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("taskName")
  private String taskName = null;

  @SerializedName("userId")
  private String userId = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("dueDate")
  private String dueDate = null;

  @SerializedName("taskStatus")
  private String taskStatus = null;

  @SerializedName("projectId")
  private String projectId = null;

  public AddTaskObject taskName(String taskName) {
    this.taskName = taskName;
    return this;
  }

   /**
   * Get taskName
   * @return taskName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public AddTaskObject userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public AddTaskObject description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AddTaskObject dueDate(String dueDate) {
    this.dueDate = dueDate;
    return this;
  }

   /**
   * Get dueDate
   * @return dueDate
  **/
  @ApiModelProperty(value = "")
  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public AddTaskObject taskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
    return this;
  }

   /**
   * Get taskStatus
   * @return taskStatus
  **/
  @ApiModelProperty(value = "")
  public String getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }

  public AddTaskObject projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * Get projectId
   * @return projectId
  **/
  @ApiModelProperty(value = "")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddTaskObject addTaskObject = (AddTaskObject) o;
    return Objects.equals(this.taskName, addTaskObject.taskName) &&
        Objects.equals(this.userId, addTaskObject.userId) &&
        Objects.equals(this.description, addTaskObject.description) &&
        Objects.equals(this.dueDate, addTaskObject.dueDate) &&
        Objects.equals(this.taskStatus, addTaskObject.taskStatus) &&
        Objects.equals(this.projectId, addTaskObject.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskName, userId, description, dueDate, taskStatus, projectId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddTaskObject {\n");
    
    sb.append("    taskName: ").append(toIndentedString(taskName)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    taskStatus: ").append(toIndentedString(taskStatus)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

