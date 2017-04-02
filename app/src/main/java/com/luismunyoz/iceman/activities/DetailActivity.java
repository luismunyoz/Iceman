package com.luismunyoz.iceman.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.luismunyoz.iceman.R;
import com.luismunyoz.iceman.databinding.ActivityDetailBinding;
import com.luismunyoz.iceman.model.Comic;
import com.luismunyoz.iceman.ui.presenters.DetailPresenter;
import com.luismunyoz.iceman.ui.presenters.DetailPresenterImpl;
import com.luismunyoz.iceman.ui.views.DetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailView {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;

    public static final String ARG_COMIC = "comic";

    private ActivityDetailBinding binding;
    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new DetailPresenterImpl(this);
        presenter.getExtras(getIntent().getExtras());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            presenter.onHomePressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void populateComic(Comic comic) {
        binding.setComic(comic);
    }
}
