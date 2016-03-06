package com.dramancompany.myzzung.dramancompany.util;

/**
 * Created by myZZUNG on 2016. 3. 2..
 */
public interface FragmentLifeInterface {

    /**
     * ViewPager에서 해당 Fragment로 화면 Change Event 가 발생했을때
     * 행동하기위한 리스너
     */
    public void onOpenFragment();

    /**
     * 해당 Fragment 를 떠날떄 행동 리스너
     */
    public void onCloseFragment();
}
