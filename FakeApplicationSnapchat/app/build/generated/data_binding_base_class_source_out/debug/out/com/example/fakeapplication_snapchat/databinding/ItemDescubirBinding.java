// Generated by view binder compiler. Do not edit!
package com.example.fakeapplication_snapchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fakeapplication_snapchat.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemDescubirBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView favorites;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView textVideoDescription;

  @NonNull
  public final TextView textVideoTitle;

  @NonNull
  public final VideoView videoView;

  private ItemDescubirBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView favorites,
      @NonNull LinearLayout linearLayout, @NonNull TextView textVideoDescription,
      @NonNull TextView textVideoTitle, @NonNull VideoView videoView) {
    this.rootView = rootView;
    this.favorites = favorites;
    this.linearLayout = linearLayout;
    this.textVideoDescription = textVideoDescription;
    this.textVideoTitle = textVideoTitle;
    this.videoView = videoView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemDescubirBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemDescubirBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_descubir, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemDescubirBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.favorites;
      ImageView favorites = ViewBindings.findChildViewById(rootView, id);
      if (favorites == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.textVideoDescription;
      TextView textVideoDescription = ViewBindings.findChildViewById(rootView, id);
      if (textVideoDescription == null) {
        break missingId;
      }

      id = R.id.textVideoTitle;
      TextView textVideoTitle = ViewBindings.findChildViewById(rootView, id);
      if (textVideoTitle == null) {
        break missingId;
      }

      id = R.id.videoView;
      VideoView videoView = ViewBindings.findChildViewById(rootView, id);
      if (videoView == null) {
        break missingId;
      }

      return new ItemDescubirBinding((ConstraintLayout) rootView, favorites, linearLayout,
          textVideoDescription, textVideoTitle, videoView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
