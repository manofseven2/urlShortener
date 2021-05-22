package com.example.urlshortener.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "URLS")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name="ORIGINAL_URL")
    private String originalUrl;
    @Basic
    @Column(name = "SHORTENED_URL", unique = true)
    private String shortenedUrl;
}
