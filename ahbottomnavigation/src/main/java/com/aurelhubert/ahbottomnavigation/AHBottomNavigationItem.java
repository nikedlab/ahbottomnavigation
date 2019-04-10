package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.appcompat.content.res.AppCompatResources;

/**
 * AHBottomNavigationItem
 * The item is display in the AHBottomNavigation layout
 */
public class AHBottomNavigationItem {
	
	private String title = "";
	private Drawable drawable;
	private int color = Color.GRAY;
	
	private
	@StringRes
	int titleRes = 0;
	private
	@DrawableRes
	int drawableRes = 0;
	private
	@ColorRes
	int colorRes = 0;
	@IdRes
	private
	int itemId = 0;

	private AHBottomNavigationItem() {}

	/**
	 * Constructor
	 *
	 * @param title    Title
	 * @param resource Drawable resource
	 */
	public AHBottomNavigationItem(String title, @DrawableRes int resource) {
		this.title = title;
		this.drawableRes = resource;
	}
	
	/**
	 * @param title    Title
	 * @param resource Drawable resource
	 * @param color    Background color
	 */
	@Deprecated
	public AHBottomNavigationItem(String title, @DrawableRes int resource, @ColorRes int color) {
		this.title = title;
		this.drawableRes = resource;
		this.color = color;
	}

	/**
	 * Constructor
	 *
	 * @param titleRes    String resource
	 * @param drawableRes Drawable resource
	 * @param colorRes    Color resource
	 */
	public AHBottomNavigationItem(@StringRes int titleRes, @DrawableRes int drawableRes, @ColorRes int colorRes) {
		this.titleRes = titleRes;
		this.drawableRes = drawableRes;
		this.colorRes = colorRes;
	}
	
	/**
	 * Constructor
	 *
	 * @param title    String
	 * @param drawable Drawable
	 */
	public AHBottomNavigationItem(String title, Drawable drawable) {
		this.title = title;
		this.drawable = drawable;
	}
	
	/**
	 * Constructor
	 *
	 * @param title    String
	 * @param drawable Drawable
	 * @param color    Color
	 */
	public AHBottomNavigationItem(String title, Drawable drawable, @ColorInt int color) {
		this.title = title;
		this.drawable = drawable;
		this.color = color;
	}
	
	public String getTitle(Context context) {
		if (titleRes != 0) {
			return context.getString(titleRes);
		}
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
		this.titleRes = 0;
	}
	
	public void setTitle(@StringRes int titleRes) {
		this.titleRes = titleRes;
		this.title = "";
	}
	
	public int getColor(Context context) {
		if (colorRes != 0) {
			return ContextCompat.getColor(context, colorRes);
		}
		return color;
	}
	
	public void setColor(@ColorInt int color) {
		this.color = color;
		this.colorRes = 0;
	}
	
	public void setColorRes(@ColorRes int colorRes) {
		this.colorRes = colorRes;
		this.color = 0;
	}
	
	public Drawable getDrawable(Context context) {
		if (drawableRes != 0) {
			try {
				return AppCompatResources.getDrawable(context, drawableRes);
			} catch (Resources.NotFoundException e) {
				return ContextCompat.getDrawable(context, drawableRes);
			}
		}
		return drawable;
	}
	
	public void setDrawable(@DrawableRes int drawableRes) {
		this.drawableRes = drawableRes;
		this.drawable = null;
	}
	
	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
		this.drawableRes = 0;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(@IdRes int itemId) {
		this.itemId = itemId;
	}

	public static class Builder {
        private String title;
        private Drawable drawable;
        private int color = Color.GRAY;

        private
        @StringRes
        int titleRes = 0;
        private
        @DrawableRes
        int drawableRes = 0;
        private
        @ColorRes
        int colorRes = 0;
        @IdRes
        private
        int itemId = 0;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDrawable(Drawable drawable) {
            this.drawable = drawable;
            return this;
        }

        public Builder setColor(int color) {
            this.color = color;
            this.colorRes = 0;
            return this;
        }

        public Builder setTitleRes(int titleRes) {
            this.titleRes = titleRes;
            return this;
        }

        public Builder setDrawableRes(int drawableRes) {
            this.drawableRes = drawableRes;
            return this;
        }

        public Builder setColorRes(int colorRes) {
            this.colorRes = colorRes;
            this.color = 0;
            return this;
        }

        public Builder setItemId(int itemId) {
            this.itemId = itemId;
            return this;
        }

        public AHBottomNavigationItem build() {
            if (this.title != null && this.titleRes > 0) {
                throw new IllegalArgumentException("The title and titleRes cannot be set simultaneously");
            }
            if (this.color > 0 && this.colorRes > 0) {
                throw new IllegalArgumentException("The color and colorRes cannot be set simultaneously");
            }
            if (this.drawable != null && this.drawableRes > 0) {
                throw new IllegalArgumentException("The drawable and drawableRes cannot be set simultaneously");
            }

            AHBottomNavigationItem clazz = new AHBottomNavigationItem();
            clazz.itemId = this.itemId;
            clazz.title = this.title;
            clazz.titleRes = this.titleRes;
            clazz.drawable = this.drawable;
            clazz.drawableRes = this.drawableRes;
            clazz.color = this.color;
            clazz.colorRes = this.colorRes;

            return clazz;
        }
    }
}
