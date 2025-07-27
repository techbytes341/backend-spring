package com.blogScrapper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user_preferences")
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "preferred_themes")
    @ElementCollection
    private List<String> preferredThemes;

    @Column(name = "preferred_companies")
    @ElementCollection
    private List<String> preferredCompanies;
}
