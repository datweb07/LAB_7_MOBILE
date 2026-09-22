package thanhdnh.ueh.edu.article_app;

public class UserProfile {
  private int id;
  private String userName;
  private String email;
  private String description;
  private String avatarUrl;
  private String hobbies;

  public UserProfile(int id, String userName, String email, String description,
                     String avatarUrl, String hobbies) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.description = description;
    this.avatarUrl = avatarUrl;
    this.hobbies = hobbies;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getHobbies() {
    return hobbies;
  }

  public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
  }
}
