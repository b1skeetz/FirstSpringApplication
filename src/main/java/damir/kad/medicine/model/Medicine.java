package damir.kad.medicine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "date_buy")
    private LocalDate dateBuy;

    @Column(name = "date_expire")
    private LocalDate dateExpire;

    private String description;

    private Integer price;
}