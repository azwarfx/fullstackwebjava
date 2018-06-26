package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="CATEGORY")
@Data
public class Category
{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String categoryName;

}
