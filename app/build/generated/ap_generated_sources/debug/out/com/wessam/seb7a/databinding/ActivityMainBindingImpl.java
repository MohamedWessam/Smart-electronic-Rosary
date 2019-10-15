package com.wessam.seb7a.databinding;
import com.wessam.seb7a.R;
import com.wessam.seb7a.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding implements com.wessam.seb7a.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView, 7);
        sViewsWithIds.put(R.id.textView5, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.ImageButton mboundView1;
    @NonNull
    private final android.widget.ImageButton mboundView4;
    @NonNull
    private final android.widget.ImageButton mboundView6;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            );
        this.button.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageButton) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView4 = (android.widget.ImageButton) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (android.widget.ImageButton) bindings[6];
        this.mboundView6.setTag(null);
        this.textView2.setTag(null);
        this.textView4.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.wessam.seb7a.generated.callback.OnClickListener(this, 3);
        mCallback4 = new com.wessam.seb7a.generated.callback.OnClickListener(this, 4);
        mCallback1 = new com.wessam.seb7a.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.wessam.seb7a.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setController((com.wessam.seb7a.ui.MainActivity) variable);
        }
        else if (BR.data == variableId) {
            setData((com.wessam.seb7a.model.Data) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setController(@Nullable com.wessam.seb7a.ui.MainActivity Controller) {
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
        else if (fieldId == BR.totalCount) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        int dataTotalCount = 0;
        com.wessam.seb7a.ui.MainActivity controller = mController;
        java.lang.String stringValueOfDataCount = null;
        int dataCount = 0;
        java.lang.String stringValueOfDataTotalCount = null;
        com.wessam.seb7a.model.Data data = mData;

        if ((dirtyFlags & 0x1dL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (data != null) {
                        // read data.totalCount
                        dataTotalCount = data.getTotalCount();
                    }


                    // read String.valueOf(data.totalCount)
                    stringValueOfDataTotalCount = java.lang.String.valueOf(dataTotalCount);
            }
            if ((dirtyFlags & 0x15L) != 0) {

                    if (data != null) {
                        // read data.count
                        dataCount = data.getCount();
                    }


                    // read String.valueOf(data.count)
                    stringValueOfDataCount = java.lang.String.valueOf(dataCount);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.button.setOnClickListener(mCallback2);
            this.mboundView1.setOnClickListener(mCallback1);
            this.mboundView4.setOnClickListener(mCallback3);
            this.mboundView6.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, stringValueOfDataCount);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView4, stringValueOfDataTotalCount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // controller
                com.wessam.seb7a.ui.MainActivity controller = mController;
                // controller != null
                boolean controllerJavaLangObjectNull = false;



                controllerJavaLangObjectNull = (controller) != (null);
                if (controllerJavaLangObjectNull) {


                    controller.clearCount();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // controller
                com.wessam.seb7a.ui.MainActivity controller = mController;
                // controller != null
                boolean controllerJavaLangObjectNull = false;



                controllerJavaLangObjectNull = (controller) != (null);
                if (controllerJavaLangObjectNull) {


                    controller.showDeleteDialog();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // controller
                com.wessam.seb7a.ui.MainActivity controller = mController;
                // controller != null
                boolean controllerJavaLangObjectNull = false;



                controllerJavaLangObjectNull = (controller) != (null);
                if (controllerJavaLangObjectNull) {


                    controller.onNightModeButtonClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // controller
                com.wessam.seb7a.ui.MainActivity controller = mController;
                // controller != null
                boolean controllerJavaLangObjectNull = false;



                controllerJavaLangObjectNull = (controller) != (null);
                if (controllerJavaLangObjectNull) {


                    controller.increaseCount();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): data
        flag 1 (0x2L): controller
        flag 2 (0x3L): data.count
        flag 3 (0x4L): data.totalCount
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}