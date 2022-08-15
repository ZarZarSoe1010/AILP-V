package com.ace.ailpv.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double fee;
    private String description;

    @Transient
    private MultipartFile videos[];

    @Transient
    private MultipartFile resources[];

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "batchCourse")
    Set<Batch> batchList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "videoCourse")
    Set<Video> videoList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceCourse")
    Set<Resource> resourceList = new HashSet<>();

}