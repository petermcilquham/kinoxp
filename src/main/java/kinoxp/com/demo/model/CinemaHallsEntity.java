package kinoxp.com.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cinema_halls", schema = "kinoxp")
public class CinemaHallsEntity {
    private int cinemaHallId;
    private String cinemaHallName;
    private Integer numOfRows;
    private Integer numOfSeatsPerRow;

    @Id
    @Column(name = "cinema_hall_id")
    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    @Basic
    @Column(name = "cinema_hall_name")
    public String getCinemaHallName() {
        return cinemaHallName;
    }

    public void setCinemaHallName(String cinemaHallName) {
        this.cinemaHallName = cinemaHallName;
    }

    @Basic
    @Column(name = "num_of_rows")
    public Integer getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(Integer numOfRows) {
        this.numOfRows = numOfRows;
    }

    @Basic
    @Column(name = "num_of_seats_per_row")
    public Integer getNumOfSeatsPerRow() {
        return numOfSeatsPerRow;
    }

    public void setNumOfSeatsPerRow(Integer numOfSeatsPerRow) {
        this.numOfSeatsPerRow = numOfSeatsPerRow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaHallsEntity that = (CinemaHallsEntity) o;
        return cinemaHallId == that.cinemaHallId &&
                Objects.equals(cinemaHallName, that.cinemaHallName) &&
                Objects.equals(numOfRows, that.numOfRows) &&
                Objects.equals(numOfSeatsPerRow, that.numOfSeatsPerRow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaHallId, cinemaHallName, numOfRows, numOfSeatsPerRow);
    }
}
