package kinoxp.com.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "shows", schema = "kinoxp")
public class ShowsEntity {
    private int showId;
    private String movieTitle;
    private int cinemaHall;
    private Date date;
    private Time startTime;
    private Time duration;
    private String genre;
    private Integer ageReq;
    private String stars;
    private byte[] movieImg;

    @Id
    @Column(name = "show_id")
    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    @Basic
    @Column(name = "movie_title")
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Basic
    @Column(name = "cinema_hall")
    public int getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(int cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "start_time")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "duration")
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "age_req")
    public Integer getAgeReq() {
        return ageReq;
    }

    public void setAgeReq(Integer ageReq) {
        this.ageReq = ageReq;
    }

    @Basic
    @Column(name = "stars")
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "movie_img")
    public byte[] getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(byte[] movieImg) {
        this.movieImg = movieImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowsEntity that = (ShowsEntity) o;
        return showId == that.showId &&
                cinemaHall == that.cinemaHall &&
                Objects.equals(movieTitle, that.movieTitle) &&
                Objects.equals(date, that.date) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(ageReq, that.ageReq) &&
                Objects.equals(stars, that.stars) &&
                Arrays.equals(movieImg, that.movieImg);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(showId, movieTitle, cinemaHall, date, startTime, duration, genre, ageReq, stars);
        result = 31 * result + Arrays.hashCode(movieImg);
        return result;
    }
}
