package com.collect.leader.ui.activity;

import android.content.Intent;
import android.databinding.ViewDataBinding;

import com.collect.leader.MainActivity;
import com.collect.leader.R;
import com.collect.leader.databinding.ActivityLoginBinding;
import com.ggh.baselibrary.base.activity.BaseDBActivity;

public class LoginActivity extends BaseDBActivity<ViewDataBinding> {

    private ActivityLoginBinding binding;

    @Override
    public void main() {
        binding = (ActivityLoginBinding) mBinding;
        binding.tvText.setText("111111111111111111");

        binding.setClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
}
