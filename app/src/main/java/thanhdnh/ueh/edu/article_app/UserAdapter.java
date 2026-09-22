package thanhdnh.ueh.edu.article_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
  private final ArrayList<UserProfile> users;
  private final Context context;

  public UserAdapter(ArrayList<UserProfile> users, Context context) {
    this.users = users;
    this.context = context;
  }

  @Override
  public int getCount() {
    return users.size();
  }

  @Override
  public UserProfile getItem(int position) {
    return users.get(position);
  }

  @Override
  public long getItemId(int position) {
    return users.get(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
      holder = new ViewHolder();
      holder.avatar = convertView.findViewById(R.id.iv_user_avatar);
      holder.userName = convertView.findViewById(R.id.tv_user_name);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    UserProfile user = getItem(position);
    holder.avatar.setImageResource(resolveAvatar(user.getAvatarUrl()));
    holder.userName.setText(user.getUserName());
    return convertView;
  }

  private int resolveAvatar(String avatarUrl) {
    String resourceName = avatarUrl;
    if (resourceName.startsWith("@drawable/")) {
      resourceName = resourceName.substring("@drawable/".length());
    }

    int resourceId = context.getResources().getIdentifier(
        resourceName, "drawable", context.getPackageName());
    return resourceId != 0 ? resourceId : R.drawable.default_avatar;
  }

  private static class ViewHolder {
    ImageView avatar;
    TextView userName;
  }
}
