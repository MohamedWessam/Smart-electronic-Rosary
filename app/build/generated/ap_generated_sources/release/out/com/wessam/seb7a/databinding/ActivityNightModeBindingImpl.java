package com.wessam.seb7a.databinding;
import com.wessam.seb7a.R;
import com.wessam.seb7a.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityNightModeBindingImpl extends ActivityNightModeBinding implements com.wessam.seb7a.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityNightModeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ActivityNightModeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            );
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.nightMoodBtn.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new com.wessam.seb7a.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.controller == variableId) {
            setController((com.wessam.seb7a.ui.NightModeActivity) variable);
        }
        else if (BR.data == variableId) {
            setData((com.wessam.seb7a.model.Data) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setController(@Nullable com.wessam.seb7a.ui.NightModeActivity Controller) {
        this.mController = Controller;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.controller);
        super.requestRebind();
    }
    public void setData(@Nullable com.wessam.seb7a.model.Data Data) {
        updateRegistration(0, Data);
        this.mData = Data;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeData((com.wessam.seb7a.model.Data) object, fieldId);
        }
        return false;
    }
    private boolean onChangeData(com.wessam.seb7a.model.Data Data, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.count) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.wessam.seb7a.ui.NightModeActivity controller = mController;
        java.lang.String stringValueOfDataCount = null;
        int dataCount = 0;
        com.wessam.seb7a.model.Data data = mData;

        if ((dirtyFlags & 0xdL) != 0) {



                if (data != null) {
                    // read data.count
                    dataCount = data.getCount();
                }


                // read String.valueOf(data.count)
                stringValueOfDataCount = java.lang.String.valueOf(dataCount);
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, stringValueOfDataCount);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.nightMoodBtn.setOnClickListener(mCallback5);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // controller
        com.wessam.seb7a.ui.NightModeActivity controller = mController;
        // controller != null
        boolean controllerJavaLangObjectNull = false;



        controllerJavaLangObjectNull = (controller) != (null);
        if (controllerJavaLangObjectNull) {


            controller.increaseCount();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): data
        flag 1 (0x2L): controller
        flag 2 (0x3L): data.count
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}