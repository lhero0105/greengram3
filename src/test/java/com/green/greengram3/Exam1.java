package com.green.greengram3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exam1 {
    @Test // 해당 메소드를 테스트 하고 싶을 때 붙혀 줍니다.메소드를 실행시켜줍니다.
    @DisplayName("테스트1") // 옵션이며, 가독성이 좋습니다.(안적으면 test1()이 뜹니다.)
    public void test1(){
        System.out.println("test1");
        int sum = 2 + 2;
        Assertions.assertEquals(5, sum);
        // 왼쪽(기대하는것)오른쪽(실제)을 비교하여 같으면 성공 다르면 실패합니다.
    }
    // 각각의 테스터는 독립적이며, 절대 서로 영향을 미치지 않습니다. 순서는 junit이 결정합니다.

    @Test
    public void test2(){
        System.out.println("test2");
        int multi = 2 * 3;
        Assertions.assertEquals(6, multi);
    }

    @Test
    public void test3(){
        Assertions.assertEquals(3, MyUtils.sum(2, 1));
        // 테스터를 다방면으로 만들어야합니다
        Assertions.assertEquals(5, MyUtils.sum(3, 2));
        Assertions.assertEquals(18, MyUtils.sum(3, 15));
    }

    @Test
    public void test4(){
        // 독립적이기에 객체화가 전역이든 지역이든 상관이 없습니다.
        MyUtils myUtils = new MyUtils();
        Assertions.assertEquals(18, myUtils.multi(3, 6));
        Assertions.assertEquals(6, myUtils.multi(2, 3));
        Assertions.assertEquals(4, myUtils.multi(2, 2));




    }
}
