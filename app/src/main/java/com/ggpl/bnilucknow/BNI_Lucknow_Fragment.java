package com.ggpl.bnilucknow;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ggpl.bnilucknow.databinding.FragmentBNILucknowBinding;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;

public class BNI_Lucknow_Fragment extends Fragment {
    private ArrayList<BNILucknowModel>bniLucknowModels;
    FragmentBNILucknowBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentBNILucknowBinding.inflate(getLayoutInflater());
        initview();
        return binding.getRoot();

    }

    private void initview() {

        //*******Banners view**************

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderData(R.drawable.sliderbanner));
        sliderDataArrayList.add(new SliderData(R.drawable.sliderbanner));
        sliderDataArrayList.add(new SliderData(R.drawable.sliderbanner));
        sliderDataArrayList.add(new SliderData(R.drawable.sliderbanner));

        SliderAdapter sliderAdapter = new SliderAdapter(getActivity(), sliderDataArrayList);

        binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        binding.slider.setSliderAdapter(sliderAdapter);
        binding.slider.setScrollTimeInSec(3);
        binding.slider.setAutoCycle(true);
        binding.slider.startAutoCycle();

        //**********BNI ALLCATEGORY*****************//

        bniLucknowModels=new ArrayList<>();
        bniLucknowModels.add(new BNILucknowModel(R.drawable.ic_baseline_add_chart_24,"BNI CHAPTERS"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.categoery,"Categories"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.categoery,"Open Category"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.ic_baseline_emoji_events_24,"Event"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.ic_baseline_newspaper_24,"News"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.gallery,"GALLERY"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.members,"MEMBERS PIN"));
        bniLucknowModels.add(new BNILucknowModel(R.drawable.members,"MEMBERS"));

        // bniLucknowModels.add(new BNILucknowModel(R.drawable.chapters,"BNI CHAPTERS"));

        BNILucknowAdapter bniLucknowAdapter=new BNILucknowAdapter(bniLucknowModels,getContext());
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setAdapter(bniLucknowAdapter);
    }
}