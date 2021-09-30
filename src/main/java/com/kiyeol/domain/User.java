package com.kiyeol.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    long uid;
    @Column(name="id",nullable = false)
    String id;
    @Column(name="pw",nullable = false)
    String pw;
    @Column(name="name",nullable = false)
    String name;
    @Column(name="score")
    int score;

}

