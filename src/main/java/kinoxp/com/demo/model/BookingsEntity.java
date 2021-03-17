package kinoxp.com.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bookings", schema = "kinoxp")
public class BookingsEntity {
    private int bookingId;
    private String customerName;
    private String customerMobileNumber;
    private int showId;
    private Integer cinemaHallId;
    private int seatNum01;
    private Integer seatNum02;
    private Integer seatNum03;
    private Integer seatNum04;
    private Integer seatNum05;

    @Id
    @Column(name = "booking_id")
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_mobile_number")
    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    @Basic
    @Column(name = "show_id")
    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    @Basic
    @Column(name = "cinema_hall_id")
    public Integer getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Integer cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    @Basic
    @Column(name = "seat_num_01")
    public int getSeatNum01() {
        return seatNum01;
    }

    public void setSeatNum01(int seatNum01) {
        this.seatNum01 = seatNum01;
    }

    @Basic
    @Column(name = "seat_num_02")
    public Integer getSeatNum02() {
        return seatNum02;
    }

    public void setSeatNum02(Integer seatNum02) {
        this.seatNum02 = seatNum02;
    }

    @Basic
    @Column(name = "seat_num_03")
    public Integer getSeatNum03() {
        return seatNum03;
    }

    public void setSeatNum03(Integer seatNum03) {
        this.seatNum03 = seatNum03;
    }

    @Basic
    @Column(name = "seat_num_04")
    public Integer getSeatNum04() {
        return seatNum04;
    }

    public void setSeatNum04(Integer seatNum04) {
        this.seatNum04 = seatNum04;
    }

    @Basic
    @Column(name = "seat_num_05")
    public Integer getSeatNum05() {
        return seatNum05;
    }

    public void setSeatNum05(Integer seatNum05) {
        this.seatNum05 = seatNum05;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingsEntity that = (BookingsEntity) o;
        return bookingId == that.bookingId &&
                customerMobileNumber == that.customerMobileNumber &&
                showId == that.showId &&
                seatNum01 == that.seatNum01 &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(cinemaHallId, that.cinemaHallId) &&
                Objects.equals(seatNum02, that.seatNum02) &&
                Objects.equals(seatNum03, that.seatNum03) &&
                Objects.equals(seatNum04, that.seatNum04) &&
                Objects.equals(seatNum05, that.seatNum05);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerName, customerMobileNumber, showId, cinemaHallId, seatNum01, seatNum02, seatNum03, seatNum04, seatNum05);
    }
}
