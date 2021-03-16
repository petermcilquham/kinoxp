package kinoxp.com.demo.service;

import kinoxp.com.demo.model.ShowsEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterShowsByDate {

    public List<ShowsEntity> returnFilteredShowList(List<ShowsEntity> list){
        List<ShowsEntity> filteredList = new ArrayList<>();

        for (ShowsEntity showsEntity : list) {
            if (showsEntity.getLocalDate().isBefore(LocalDate.now().plusMonths(3))) {
                filteredList.add(showsEntity);
            }
        }
        return filteredList;
    }

}
