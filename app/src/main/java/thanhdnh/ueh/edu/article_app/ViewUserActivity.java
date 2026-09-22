package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewUserActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_user);

    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }

    int userId = (int) getIntent().getLongExtra(MainActivity.EXTRA_USER_ID, -1);
    UserProfile user = MainActivity.getUserById(userId);
    if (user == null) {
      finish();
      return;
    }

    ImageView avatar = findViewById(R.id.iv_detail_avatar);
    TextView userName = findViewById(R.id.tv_detail_user_name);
    TextView id = findViewById(R.id.tv_detail_id);
    TextView email = findViewById(R.id.tv_detail_email);
    TextView hobbies = findViewById(R.id.tv_detail_hobbies);
    TextView description = findViewById(R.id.tv_detail_description);

    avatar.setImageResource(resolveAvatar(user.getAvatarUrl()));
    userName.setText(user.getUserName());
    id.setText(getString(R.string.user_id_value, user.getId()));
    email.setText(getString(R.string.email_value, user.getEmail()));
    hobbies.setText(getString(R.string.hobbies_value, user.getHobbies()));
    description.setText(user.getDescription());
  }

  private int resolveAvatar(String avatarUrl) {
    String resourceName = avatarUrl;
    if (resourceName.startsWith("@drawable/")) {
      resourceName = resourceName.substring("@drawable/".length());
    }

    int resourceId = getResources().getIdentifier(resourceName, "drawable", getPackageName());
    return resourceId != 0 ? resourceId : R.drawable.default_avatar;
  }
}
