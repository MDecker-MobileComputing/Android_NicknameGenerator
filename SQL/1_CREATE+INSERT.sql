
CREATE TABLE ADJEKTIVE (

  adjektiv_id INTEGER PRIMARY KEY,
  adjektiv    TEXT    NOT NULL
);

CREATE TABLE SUBSTANTIVE (

  substantiv_id INTEGER PRIMARY KEY,
  substantiv    TEXT    NOT NULL
);

INSERT INTO ADJEKTIVE (adjektiv) VALUES
    ("Awesome"), ("Brave"), ("Clever"), ("Daring"), ("Eager"), ("Fantastic"),
    ("Gentle"), ("Happy"), ("Intelligent"), ("Jolly"), ("Kind"), ("Lively"), 
    ("Magnificent"), ("Nice"), ("Optimistic"), ("Pleasant"), ("Quirky"), 
    ("Radiant"), ("Silly"), ("Thoughtful"), ("Unique"), ("Vibrant"), ("Witty"), 
    ("Xenial"), ("Youthful"), ("Zealous");
    
INSERT INTO SUBSTANTIVE (substantiv) VALUES
   ("Ant"), ("Bear"), ("Cat"), ("Dog"), ("Elephant"), ("Frog"), ("Giraffe"),
   ("Horse"), ("Iguana"), ("Jaguar"), ("Kangaroo"), ("Lion"), ("Monkey"), 
   ("Narwhal"), ("Owl"), ("Penguin"), ("Quokka"), ("Rabbit"), ("Snake"), 
   ("Turtle"), ("Unicorn"), ("Vulture"), ("Whale"), 
   ("Xylophone"), ("Yak"), ("Zebra");
