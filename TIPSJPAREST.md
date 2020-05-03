https://www.jhipster.tech/jhipster-uml/
http://www.umldesigner.org/tutorials/tuto-getting-started.html
https://docs.oracle.com/cd/B28359_01/server.111/b28328/diagrams.htm#G5482

<!-- Pour remplacer swagger /hal-browser
		http://localhost:8088/
		or
		http://localhost:8088/browser/index.html#/api
		or
		http://localhost:8088/api/
		or
		http://localhost:8088/api/browser/index.html#/api
		-->


*** UML to JAVA  Generator 3.0  /Acceleo / Obeo  Plugin to  UML Designer
** Eclipse : Obeo  Designer  Community  UML Editor

##  Inheritance Mapping
How do you organize a hierarchical model into a flat relational one? JPA has three different strategies you can
choose from.
•	 A single-table-per-class hierarchy strategy: The sum of the attributes of the entire entity
hierarchy is flattened down to a single table (this is the default strategy).
•	 A joined-subclass strategy: In this approach, each entity in the hierarchy, concrete or abstract,
is mapped to its own dedicated table.
•	 A table-per-concrete-class strategy: This strategy maps each concrete entity hierarchy to its own
separate table.

## All Possible Cardinality-Direction Combinations

Cardinality // Direction
One-to-one Unidirectional
One-to-one Bidirectional
One-to-many Unidirectional
Many-to-one/one-to-many Bidirectional
Many-to-one Unidirectional
Many-to-many Unidirectional
Many-to-many Bidirectional

# Relationships in Relational Databases
This reference can be modeled in two different ways: by using a foreign key (a join column) or by
using a join table. In database terms, a column that refers to a key of another table is a foreign key column.

## mappedBy / owning side

How do you map a pair of unidirectional relationships? Who is the owner of this bidirectional relationship? Who
owns the mapping information of the join column or the join table? If unidirectional relationships have an owning side,
bidirectional ones have both an owning and an inverse side, which have to be explicitly specified with the mappedBy
element of the @OneToOne, @OneToMany, and @ManyToMany annotations. mappedBy identifies the attribute that owns the
relationship and is required for bidirectional relationships.


## Fetching Relationships
All the annotations that you have seen (@OneToOne, @OneToMany, @ManyToOne, and @ManyToMany) define a fetching
attribute, specifying the associated objects to be loaded immediately (eagerly) or deferred (lazily), with a resulting
impact on performance. Depending on your application, certain relationships are accessed more often than others.
In these situations, you can optimize performance by loading data from the database when.

### Default Fetching Strategies
Annotation Default Fetching Strategy
@OneToOne EAGER
@ManyToOne EAGER
@OneToMany LAZY
@ManyToMany LAZY

## Ordering Relationships / @OrderBy
With one-to-many or many-to-many relationships, your entities deal with collections of objects. On the Java side, these
collections are usually unordered. Neither do relational databases preserve any order in their tables. Therefore, if you
want an ordered list, it is necessary to either sort your collection programmatically or use a JPQL query with an Order
By clause. JPA has easier mechanisms, based on annotations that can help in ordering relationships.

##  Many-to-Many With a New Entity 'Table intermediare" https://www.baeldung.com/jpa-many-to-many
Etudiant /Inscription /Cours