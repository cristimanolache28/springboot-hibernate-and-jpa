## This project was made for improving skill of working using Spring Data Component from Spring Framework Ecosystem.

In this project I've created relationships unidirectional and birectional between tables (ex: @OneToOne, @ManyToOne, @OneToMany and @ManyToMany)

## Project Documentation

### Relationship Between Entities
Student -> Course => @ManyToMany

Course -> Student => @ManyToMany

Student -> Passport => @OneToOne

Passport -> Student => @OneToOne

Course -> Review => @OneToMany

Review -> Course => @ManyToOne

## Info
**Uniderectional Relationship:** A relationship is created between two entities in a uniderectional association, but **only one entity is aware of the other**. This indicates that just one side of the association has a reference to the other side in JPA and Hibernate. This is know as the **owning side**, while the other side is known as the **inverse side**.

**Bidirectional Relationship:** A bidirectional association is one in which two entities have a relationship and are aware of one other. Both side of the association is JPA and Hibernate contain references to each other, resulting in a two-way relationship.  


### Unidirectional Relationship Use Cases
**Queryning**: If you need to navigate from the invers side to the owning side (e.g retriving the Author entity from a Book entity), you will need to perform additional queries or manual mapping.
<br>**Limited navigation**: Without a reference from the inverse side, you wan't be able  to navigate from the Book entity to the Author entity class.</br>


### Bidirectional Relationship Use Cases 

**Increase complexity**: Bidirectional associations add complexity, as both sides need to be synchronized to maintain the integrity of the relationship.

**Performance impact**: Bidirectional associations may introduce addtional overhead due the need for mapping and syncronizing both sides of the associations

**Uniderectional Relationship** is good when we want to have simple associations, one-to-many relationship, and performance considerations.

**Bidirectional Relationship**: is good when we want to have navigational requirements, cascading operations (propagate from parent entity to the child entity) and data integrity.



**@**ToMany** => Default **FetchType = EAGER** (@ManyToMany, @OneToMany)

**@**ToMany** => Default **FetchType = LAZY** (@OneToMany, @ManyToMany)


## Useful things found after completing the course

**Hibernate** is the implementation for JPA.

**@Transactional** gets you consistent data!




### New Knowledge
**Hibernet Dialect** is a language which is used by the database for communication.
  * **org.hibernate.dialect** is the package where the dialect is available in Java class. It helps in mapping the application in Java with the Database.



### Annotation:
   1. **@Entity** annotation specifies that the class is an entity.
   2. **@Table** annotation specifies the table in the Databe with which this entity is mapped.
   3. **@GeneratedValue** annotation specifies the generation strategies for the values of primary keys. 
   4. **@RestController** is a convenient annotation that combines **@Controllor** and **@ResponseBody**, which eliminates the need to annotate every request handling method of 
 the controller class with the **@ResponseBody annotation**.
   5. **@RequestBody** annotation allows us to retrieve the request's body and automatically convert it to Java Object.
   6. 


       And this is the second line.&lt;/p&gt;</code>
  </td>
  <td>
    <p>This is the first line.<br />   
    And this is the second line.</p>
  </td>
</tr>
