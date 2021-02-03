package com.michelAdrien.AMTT0121.View.list.subpage

/*
class ListSubFragmentFactory(val listViewModel: DeviceListViewModel, val searchType:Int) : FragmentFactory() {
    @NonNull
    override fun instantiate(@NonNull classLoader : ClassLoader, @NonNull className : String)  : Fragment {
        Log.d("TestSubFragment", ListSubFragment::class.java.name)

        val clazz : Class<out Fragment> = loadFragmentClass(classLoader, className)
        if (clazz == ListSubFragment::class.java) {
            return ListSubFragment(listViewModel, searchType)
        }
        else {
            return super.instantiate(classLoader, className)
        }
    }
}*/