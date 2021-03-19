package kinoxp.com.demo.service;

import kinoxp.com.demo.model.ShowsEntity;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterShowsByDateTest {

    @Test
    void returnFilteredShowList() {
        ShowsEntity show1 = new ShowsEntity();
        ShowsEntity show2 = new ShowsEntity();
        ShowsEntity show3 = new ShowsEntity();
        show1.setDate(new Date(System.currentTimeMillis()));
        show2.setDate(new Date((long) (System.currentTimeMillis()+8.64e+7*90)));
        show3.setDate(new Date((long) (System.currentTimeMillis()+8.64e+7*92)));

        List<ShowsEntity> testDataList = new ArrayList<>();
        testDataList.add(show1);
        testDataList.add(show2);
        testDataList.add(show3);

        List<ShowsEntity> resultList;
        List<ShowsEntity> correctList = new ArrayList<>();
        correctList.add(show1);
        correctList.add(show2);

        FilterShowsByDate filterClass = new FilterShowsByDate();
        resultList = filterClass.returnFilteredShowList(testDataList);

        assertEquals(correctList,resultList);
    }
}