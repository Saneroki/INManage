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
 * InlineResponse200
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-17T13:13:02.559Z")
public class InlineResponse200 implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("msg")
  private String msg = null;

  @SerializedName("timeStamp")
  private String timeStamp = null;

  public InlineResponse200 msg(String msg) {
    this.msg = msg;
    return this;
  }

   /**
   * Get msg
   * @return msg
  **/
  @ApiModelProperty(value = "")
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public InlineResponse200 timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

   /**
   * Get timeStamp
   * @return timeStamp
  **/
  @ApiModelProperty(value = "")
  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.msg, inlineResponse200.msg) &&
        Objects.equals(this.timeStamp, inlineResponse200.timeStamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg, timeStamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
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

