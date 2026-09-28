package thanhdnh.ueh.edu.article_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  public static final String EXTRA_USER_ID = "id";
  private GridView gridView;

  private final AdapterView.OnItemClickListener onItemClick =
      (AdapterView<?> parent, View view, int position, long id) -> {
        Intent intent = new Intent(MainActivity.this, ViewUserActivity.class);
        intent.putExtra(EXTRA_USER_ID, gridView.getAdapter().getItemId(position));
        startActivity(intent);
      };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }

    gridView = findViewById(R.id.gridview);
    new UserData(getBaseContext(), gridView).loadData(
        "https://gist.githubusercontent.com/datweb07/e708b92074183c26152b893d1be72c91/raw/e4fcc45f79e4f79b7933d27bca2174385fc92c28/users.json",
        this);
    gridView.setOnItemClickListener(onItemClick);
  }

  public static UserProfile getUserById(int id) {
    return UserData.getUserById(id);
  }
}
