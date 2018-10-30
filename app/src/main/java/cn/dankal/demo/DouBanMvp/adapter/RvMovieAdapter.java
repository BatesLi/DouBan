package cn.dankal.demo.DouBanMvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.demo.R;
import java.util.List;

public class RvMovieAdapter extends RecyclerView.Adapter<RvMovieAdapter.MovieHolder> {

  public List<Integer> mData;
  public Context mContext;

  public RvMovieAdapter(Context context, List<Integer> data) {
    this.mContext = context;
    this.mData = data;
  }

  @NonNull @Override
  public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item__zhihu, parent, false);
    MovieHolder movieHolder = new MovieHolder(view);
    return movieHolder;
  }

  @Override public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return mData.size();
  }

  public class MovieHolder extends RecyclerView.ViewHolder {

    /*@BindView(R.id.img_movie) ImageView mImgMovie;
    @BindView(R.id.rating_bar_star) RatingBar mRatingBarStar;
    @BindView(R.id.txt_movie_score) TextView mTxtMovieScore;
    @BindView(R.id.txt_movie_name) TextView mTxtMovieName;*/

    public MovieHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

