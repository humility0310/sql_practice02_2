SELECT author_seq.NEXTVAL FROM DUAL;

SELECT AUTHOR_seq.CURRVAL FROM DUAL;

select * FROM AUTHOR;
commit;
UPDATE AUTHOR SET NO=3 WHERE NO=4;
