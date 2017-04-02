package com.luismunyoz.iceman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luismunyoz.iceman.R;
import com.luismunyoz.iceman.adapters.ComicsAdapter;
import com.luismunyoz.iceman.model.Character;
import com.luismunyoz.iceman.model.Comic;
import com.luismunyoz.iceman.ui.presenters.MainPresenter;
import com.luismunyoz.iceman.ui.presenters.MainPresenterImpl;
import com.luismunyoz.iceman.ui.views.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_list)
    RecyclerView list;
    @BindView(R.id.main_image)
    ImageView image;
    @BindView(R.id.main_loader)
    FrameLayout loader;

    private MainPresenter presenter;
    private ComicsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        presenter = new MainPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void populateCharacter(Character character) {
        getSupportActionBar().setTitle(character.getName());
        if(character.getThumbnail() != null) {
            Glide.with(this).load(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension()).into(image);
        }
    }

    @Override
    public void populateComics(List<Comic> comics) {
        loader.setVisibility(View.GONE);
        adapter = new ComicsAdapter(R.layout.layout_comic_item, presenter);
        list.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        list.setAdapter(adapter);
        adapter.setComics(comics);
    }

    @Override
    public void goToComicDetail(Comic comic) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(DetailActivity.ARG_COMIC, comic);
        openActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }
}
