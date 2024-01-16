package damir.kad.medicine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Boolean display;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_buy")
    private LocalDate dateBuy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_expire")
    private LocalDate dateExpire;

    private String description;

    private Integer price;
}