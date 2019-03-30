package com.example.practicafinalbase;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.practicafinalbase.beans.English;
import com.example.practicafinalbase.beans.Spanish;
import com.example.practicafinalbase.recoverinfo.RequestInfoActivity;
import com.example.practicafinalbase.recoverinfo.constants.Constants;
import com.example.practicafinalbase.recoverinfo.dto.HeroInfo;
import com.example.practicafinalbase.views.CustomView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.res.BooleanRes;

@EActivity(R.layout.activity_main)
@WindowFeature(Window.FEATURE_NO_TITLE)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.b_english_change)
    Button bEnglishChange;

    @ViewById(R.id.b_spanish_change)
    Button bSpannishChange;

    @ViewById
    ImageButton ib_next, ib_back;

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.container)
    CustomView customView;

    @Bean
    Spanish spanish;
    @Bean
    English english;

    @App
    RequestInfoActivity receiverAction;

    @AnimationRes
    Animation fade_in, appear;

    @BooleanRes
    boolean is_fade_in;

    int counterAvenger = 0;
    HeroInfo heroe;

    @AfterViews
    void initAfterViews() {
        heroe = receiverAction.callHero(0, Constants.EN);
        customView.setInfo(heroe);
    }

    @Click(R.id.b_english_change)
    void changeToEnglish() {
        changeTextFromToolbar(english.getAppName(), english.getBSelectEn(), english.getBSelectSp());
        changeCustomView(Constants.EN);
    }

    @Click(R.id.b_spanish_change)
    void changeToSpanish() {
        changeTextFromToolbar(spanish.getAppName(), spanish.getBSelectEn(), spanish.getBSelectSp());
        changeCustomView(Constants.ES);

    }

    private void changeTextFromToolbar(String app_name, String b_select_en, String b_select_sp) {
        if (is_fade_in) {
            toolbar.startAnimation(fade_in);
        } else {
            toolbar.startAnimation(appear);
        }
        toolbar.setTitle(app_name);
        bEnglishChange.setText(b_select_en);
        bSpannishChange.setText(b_select_sp);
    }

    private void changeCustomView(String language) {
        if (is_fade_in) {
            customView.startAnimation(fade_in);
            ib_next.startAnimation(fade_in);
            ib_back.startAnimation(fade_in);
        } else {
            customView.startAnimation(appear);
            ib_next.startAnimation(appear);
            ib_back.startAnimation(appear);
        }

        heroe = receiverAction.callHero(heroe.getId(), language);
        customView.setInfo(heroe);
    }

    @Click(R.id.ib_next)
    void nextAvenger() {
        String language = heroe.getLanguage();
        counterAvenger = (counterAvenger+1)%6;
        heroe = receiverAction.callHero(counterAvenger, language);
        customView.setInfo(heroe);
    }

    @Click(R.id.ib_back)
    void backAvenger() {
        String language = heroe.getLanguage();
        counterAvenger = (counterAvenger-1)%6;
        if (counterAvenger == -1) {
            counterAvenger = 5;
        }
        heroe = receiverAction.callHero(counterAvenger, language);
        customView.setInfo(heroe);
    }
}
