package com.example.backendsimplemovies.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "overview", nullable = false, columnDefinition = "varchar(500)")
    private String overview;

    @Column(name = "poster_path", nullable = false)
    private String posterPath;

    @Column(name = "backdrop_path", nullable = false)
    private String backdropPath;

    private Double popularity;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "vote_count")
    private Integer voteCount;

    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToMany()
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id") )
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id", referencedColumnName = "id") )
    private List<Cast> casts = new ArrayList<>();

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Video> videos = new ArrayList<>();
}
