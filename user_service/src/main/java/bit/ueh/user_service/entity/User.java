package bit.ueh.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id", referencedColumnName = "id", nullable = false)
    private CCCD cccd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = true)
    private Card card;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(columnDefinition = "double default 0")
    private double balance = 0;
}