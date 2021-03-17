package kinoxp.com.demo.service;

import kinoxp.com.demo.model.ShowsEntity;

import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterShowsByDate {

    public List<ShowsEntity> returnFilteredShowList(List<ShowsEntity> list){
        List<ShowsEntity> filteredList = new ArrayList<>();

        for(ShowsEntity showsEntity : list){
            if(showsEntity.getDate().before(Date.from(Instant.now().plus(Period.ofDays(90))))){
                filteredList.add(showsEntity);
            }
        }
        return filteredList;
    }

}
