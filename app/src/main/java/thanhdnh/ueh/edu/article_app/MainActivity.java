package thanhdnh.ueh.edu.article_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  public static final String EXTRA_USER_ID = "id";
  private static UserList userList;
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

    userList = createUsers();
    gridView = findViewById(R.id.gridview);
    gridView.setAdapter(new UserAdapter(userList.getUsers(), this));
    gridView.setOnItemClickListener(onItemClick);
  }

  public static UserProfile getUserById(int id) {
    return userList == null ? null : userList.getUserById(id);
  }

  private UserList createUsers() {
    ArrayList<UserProfile> users = new ArrayList<>();
    users.add(new UserProfile(1, "Đặng Ngọc Hoàng Thành", "thanhdnh@ueh.edu.vn",
        "Thành là người cởi mở, thích khám phá những địa điểm mới và chia sẻ trải nghiệm với bạn bè.",
        "@drawable/avatar_1", "Du lịch, nhiếp ảnh, đọc sách"));
    users.add(new UserProfile(2, "Nguyễn Quốc Hùng", "hungngq@ueh.edu.vn",
        "Hùng yêu công nghệ và thường dành thời gian rảnh để tìm hiểu các ứng dụng di động.",
        "@drawable/avatar_2", "Công nghệ, game, bóng đá"));
    users.add(new UserProfile(3, "Trương Thành Đạt", "thuha@example.com",
        "Thu Hà yêu thích sự sáng tạo, luôn muốn học thêm kỹ năng mới và tham gia các hoạt động cộng đồng.",
        "@drawable/avatar_3", "Vẽ, âm nhạc, tình nguyện"));
    users.add(new UserProfile(4, "Nguyễn Tấn Khiêm", "giahuy@example.com",
        "Gia Huy là người năng động, thân thiện và quan tâm đến việc rèn luyện sức khỏe mỗi ngày.",
        "@drawable/avatar_4", "Thể thao, chạy bộ, phim ảnh"));
    users.add(new UserProfile(5, "Phan Nhựt Đăng Khoa", "ngoclan@example.com",
        "Ngọc Lan thích nấu ăn và ghi lại những khoảnh khắc bình dị trong cuộc sống.",
        "@drawable/avatar_5", "Nấu ăn, chụp ảnh, trồng cây"));
    users.add(new UserProfile(6, "Nguyễn Văn A", "quocbao@example.com",
        "Quốc Bảo đam mê lập trình, thích làm việc nhóm và giải quyết những bài toán khó.",
        "@drawable/avatar_6", "Lập trình, game, cầu lông"));
    users.add(new UserProfile(7, "Bùi Khánh Linh", "khanhlinh@example.com",
        "Khánh Linh yêu sách, thích học ngoại ngữ và luôn tìm kiếm những góc nhìn mới.",
        "@drawable/avatar_7", "Đọc sách, ngoại ngữ, du lịch"));
    return new UserList(users);
  }
}
