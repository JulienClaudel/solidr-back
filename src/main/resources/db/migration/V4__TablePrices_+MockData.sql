/*==============================================================*/
/* Table : TABLEPRICE                                           */
/*==============================================================*/
create table TABLEPRICE
(
    TABLEPRICE_ID           numeric identity,
    TABLEPRICE_PERIOD       varchar(10) not null,
    TABLEPRICE_AMOUNT       varchar(10) not null,
    TABLEPRICE_TEXT1        varchar(20),
    TABLEPRICE_TEXT2        varchar(20),
    TABLEPRICE_TEXT3        varchar(20),
    TABLEPRICE_TEXT4        varchar(20),
    constraint PK_TABLEPRICE primary key (TABLEPRICE_ID),
)
    go


/*==============================================================*/
INSERT INTO dbo.TABLEPRICE(TABLEPRICE_PERIOD, TABLEPRICE_AMOUNT, TABLEPRICE_TEXT1, TABLEPRICE_TEXT2, TABLEPRICE_TEXT3, TABLEPRICE_TEXT4)
VALUES ('DAY', '1', '1 Strategy', '24 Hours', 'simple plan', 'no subscription');
INSERT INTO dbo.TABLEPRICE(TABLEPRICE_PERIOD, TABLEPRICE_AMOUNT, TABLEPRICE_TEXT1, TABLEPRICE_TEXT2, TABLEPRICE_TEXT3, TABLEPRICE_TEXT4)
VALUES ('Month', '28', '1 Strategy', '30 Days', 'Follower Special!', 'Best Choice!');
INSERT INTO dbo.TABLEPRICE(TABLEPRICE_PERIOD, TABLEPRICE_AMOUNT, TABLEPRICE_TEXT1, TABLEPRICE_TEXT2, TABLEPRICE_TEXT3, TABLEPRICE_TEXT4)
VALUES ('MULTIPLE', '100', 'Credit', 'all strategies', 'unrestricted use', 'unlimited validity');



/*==============================================================*/
