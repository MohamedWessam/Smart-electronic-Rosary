package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.wessam.seb7a.DataBinderMapperImpl());
  }
}
