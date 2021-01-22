/*==============================================================*/
/* Nom de SGBD :  Microsoft SQL Server 2016                     */
/* Date de création :  17/11/2020 23:19:53                      */
/*==============================================================*/


if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('COMMENT')
            and o.name = 'FK_COMMENT_CONTAIN_C_STRATEGY')
alter table COMMENT
    drop constraint FK_COMMENT_CONTAIN_C_STRATEGY
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('COMMENT')
            and o.name = 'FK_COMMENT_MANAGE_CO_USER_DAT')
alter table COMMENT
    drop constraint FK_COMMENT_MANAGE_CO_USER_DAT
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('COMMENT')
            and o.name = 'FK_COMMENT_SET_STATU_STATUS')
alter table COMMENT
    drop constraint FK_COMMENT_SET_STATU_STATUS
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('PROFIL_FONCTION')
            and o.name = 'FK_PROFIL_F_PROFIL_FO_PROFIL')
alter table PROFIL_FONCTION
    drop constraint FK_PROFIL_F_PROFIL_FO_PROFIL
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('PROFIL_FONCTION')
            and o.name = 'FK_PROFIL_F_PROFIL_FO_FONCTION')
alter table PROFIL_FONCTION
    drop constraint FK_PROFIL_F_PROFIL_FO_FONCTION
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('STRATEGY')
            and o.name = 'FK_STRATEGY_MANAGE_ST_USER_DAT')
alter table STRATEGY
    drop constraint FK_STRATEGY_MANAGE_ST_USER_DAT
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('STRATEGY')
            and o.name = 'FK_STRATEGY_SET_STATU_STATUS')
alter table STRATEGY
    drop constraint FK_STRATEGY_SET_STATU_STATUS
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('TRADE')
            and o.name = 'FK_TRADE_MANAGE_TR_USER_DAT')
alter table TRADE
    drop constraint FK_TRADE_MANAGE_TR_USER_DAT
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('TRADE')
            and o.name = 'FK_TRADE_SET_STATU_STATUS')
alter table TRADE
    drop constraint FK_TRADE_SET_STATU_STATUS
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('USER_DATA')
            and o.name = 'FK_USER_DAT_SET_STATU_STATUS')
alter table USER_DATA
    drop constraint FK_USER_DAT_SET_STATU_STATUS
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('USER_PROFIL')
            and o.name = 'FK_USER_PRO_USER_PROF_USER_DAT')
alter table USER_PROFIL
    drop constraint FK_USER_PRO_USER_PROF_USER_DAT
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('USER_PROFIL')
            and o.name = 'FK_USER_PRO_USER_PROF_PROFIL')
alter table USER_PROFIL
    drop constraint FK_USER_PRO_USER_PROF_PROFIL
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('USER_SUBSCRIBE_STRAT')
            and o.name = 'FK_USER_SUB_USER_SUBS_STRATEGY')
alter table USER_SUBSCRIBE_STRAT
    drop constraint FK_USER_SUB_USER_SUBS_STRATEGY
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('USER_SUBSCRIBE_STRAT')
            and o.name = 'FK_USER_SUB_USER_SUBS_USER_DAT')
alter table USER_SUBSCRIBE_STRAT
    drop constraint FK_USER_SUB_USER_SUBS_USER_DAT
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('WALLET')
            and o.name = 'FK_WALLET_OWN_USER_DAT')
alter table WALLET
    drop constraint FK_WALLET_OWN_USER_DAT
go

if exists(select 1
          from sys.sysreferences r
                   join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
          where r.fkeyid = object_id('WALLET_HISTORY')
            and o.name = 'FK_WALLET_H_SAVE_WALL_WALLET')
alter table WALLET_HISTORY
    drop constraint FK_WALLET_H_SAVE_WALL_WALLET
go

if exists(select 1
          from sysobjects
          where id = object_id('API_CORP')
            and type = 'U')
    drop table API_CORP
go

if exists(select 1
          from sysindexes
          where id = object_id('COMMENT')
            and name = 'SET_STATUS_COMMENT_FK'
            and indid > 0
            and indid < 255)
    drop index COMMENT.SET_STATUS_COMMENT_FK
go

if exists(select 1
          from sysindexes
          where id = object_id('COMMENT')
            and name = 'CONTAIN_COMMENT_FK'
            and indid > 0
            and indid < 255)
    drop index COMMENT.CONTAIN_COMMENT_FK
go

if exists(select 1
          from sysindexes
          where id = object_id('COMMENT')
            and name = 'MANAGE_COMMENT_FK'
            and indid > 0
            and indid < 255)
    drop index COMMENT.MANAGE_COMMENT_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('COMMENT')
            and type = 'U')
    drop table COMMENT
go

if exists(select 1
          from sysobjects
          where id = object_id('FONCTION')
            and type = 'U')
    drop table FONCTION
go

if exists(select 1
          from sysobjects
          where id = object_id('INFORMATION')
            and type = 'U')
    drop table INFORMATION
go

if exists(select 1
          from sysobjects
          where id = object_id('PROFIL')
            and type = 'U')
    drop table PROFIL
go

if exists(select 1
          from sysindexes
          where id = object_id('PROFIL_FONCTION')
            and name = 'CAN2_FK'
            and indid > 0
            and indid < 255)
    drop index PROFIL_FONCTION.CAN2_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('PROFIL_FONCTION')
            and type = 'U')
    drop table PROFIL_FONCTION
go

if exists(select 1
          from sysobjects
          where id = object_id('STATUS')
            and type = 'U')
    drop table STATUS
go

if exists(select 1
          from sysindexes
          where id = object_id('STRATEGY')
            and name = 'SET_STATUS_STRATEGY_FK'
            and indid > 0
            and indid < 255)
    drop index STRATEGY.SET_STATUS_STRATEGY_FK
go

if exists(select 1
          from sysindexes
          where id = object_id('STRATEGY')
            and name = 'MANAGE_STRAT_FK'
            and indid > 0
            and indid < 255)
    drop index STRATEGY.MANAGE_STRAT_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('STRATEGY')
            and type = 'U')
    drop table STRATEGY
go

if exists(select 1
          from sysindexes
          where id = object_id('TRADE')
            and name = 'SET_STATUS_TRADE_FK'
            and indid > 0
            and indid < 255)
    drop index TRADE.SET_STATUS_TRADE_FK
go

if exists(select 1
          from sysindexes
          where id = object_id('TRADE')
            and name = 'MANAGE_TRADE_FK'
            and indid > 0
            and indid < 255)
    drop index TRADE.MANAGE_TRADE_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('TRADE')
            and type = 'U')
    drop table TRADE
go

if exists(select 1
          from sysindexes
          where id = object_id('USER_DATA')
            and name = 'SET_STATUS_USER_FK'
            and indid > 0
            and indid < 255)
    drop index USER_DATA.SET_STATUS_USER_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('USER_DATA')
            and type = 'U')
    drop table USER_DATA
go

if exists(select 1
          from sysindexes
          where id = object_id('USER_PROFIL')
            and name = 'HAVE2_FK'
            and indid > 0
            and indid < 255)
    drop index USER_PROFIL.HAVE2_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('USER_PROFIL')
            and type = 'U')
    drop table USER_PROFIL
go

if exists(select 1
          from sysindexes
          where id = object_id('USER_SUBSCRIBE_STRAT')
            and name = 'SUBSCRIBE_STRAT2_FK'
            and indid > 0
            and indid < 255)
    drop index USER_SUBSCRIBE_STRAT.SUBSCRIBE_STRAT2_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('USER_SUBSCRIBE_STRAT')
            and type = 'U')
    drop table USER_SUBSCRIBE_STRAT
go

if exists(select 1
          from sysobjects
          where id = object_id('WALLET')
            and type = 'U')
    drop table WALLET
go

if exists(select 1
          from sysindexes
          where id = object_id('WALLET_HISTORY')
            and name = 'SAVE_WALLET_HISTORY_FK'
            and indid > 0
            and indid < 255)
    drop index WALLET_HISTORY.SAVE_WALLET_HISTORY_FK
go

if exists(select 1
          from sysobjects
          where id = object_id('WALLET_HISTORY')
            and type = 'U')
    drop table WALLET_HISTORY
go

/*==============================================================*/
/* Table : API_CORP                                             */
/*==============================================================*/
create table API_CORP
(
    API_ID    numeric identity,
    API_LABEL varchar(50)  not null,
    API_LINK  varchar(100) not null,
    API_ICON  binary(1)    null,
    constraint PK_API_CORP primary key (API_ID)
)
go

/*==============================================================*/
/* Table : COMMENT                                              */
/*==============================================================*/
create table COMMENT
(
    COMMENT_ID            numeric identity,
    STRATEGY_ID           numeric     not null,
    STATUS_ID             numeric     not null,
    USER_EMAIL            varchar(60) not null,
    COMMENT_SCORE         int         null,
    COMMENT_DESCRIPTION   text        null,
    COMMENT_CREATION_DATE datetime    not null,
    COMMENT_UPDATE_DATE   datetime    not null,
    COMMENT_MEMBER_IP     varchar(50) not null,
    constraint PK_COMMENT primary key (COMMENT_ID)
)
go

/*==============================================================*/
/* Index : MANAGE_COMMENT_FK                                    */
/*==============================================================*/




create nonclustered index MANAGE_COMMENT_FK on COMMENT (USER_EMAIL ASC)
go

/*==============================================================*/
/* Index : CONTAIN_COMMENT_FK                                   */
/*==============================================================*/




create nonclustered index CONTAIN_COMMENT_FK on COMMENT (STRATEGY_ID ASC)
go

/*==============================================================*/
/* Index : SET_STATUS_COMMENT_FK                                */
/*==============================================================*/




create nonclustered index SET_STATUS_COMMENT_FK on COMMENT (STATUS_ID ASC)
go

/*==============================================================*/
/* Table : FONCTION                                             */
/*==============================================================*/
create table FONCTION
(
    FONCTION_ID          numeric identity,
    FONCTION_LABEL       varchar(50)  not null,
    FONCTION_DESCRIPTION varchar(100) not null,
    constraint PK_FONCTION primary key (FONCTION_ID)
)
go

/*==============================================================*/
/* Table : INFORMATION                                          */
/*==============================================================*/
create table INFORMATION
(
    INFORMATION_ID          numeric identity,
    INFORMATION_TYPE        varchar(50) not null,
    INFORMATION_CODE        varchar(50) not null,
    INFORMATION_DESCRIPTION text        not null,
    constraint PK_INFORMATION primary key (INFORMATION_ID)
)
go

/*==============================================================*/
/* Table : PROFIL                                               */
/*==============================================================*/
create table PROFIL
(
    PROFIL_ID          numeric identity,
    PROFIL_LABEL       varchar(50)  not null,
    PROFIL_DESCRIPTION varchar(100) not null,
    constraint PK_PROFIL primary key (PROFIL_ID)
)
go

/*==============================================================*/
/* Table : PROFIL_FONCTION                                      */
/*==============================================================*/
create table PROFIL_FONCTION
(
    PROFIL_ID   numeric not null,
    FONCTION_ID numeric not null,
    constraint PK_PROFIL_FONCTION primary key (PROFIL_ID, FONCTION_ID)
)
go

/*==============================================================*/
/* Index : CAN2_FK                                              */
/*==============================================================*/




create nonclustered index CAN2_FK on PROFIL_FONCTION (FONCTION_ID ASC)
go

/*==============================================================*/
/* Table : STATUS                                               */
/*==============================================================*/
create table STATUS
(
    STATUS_ID          numeric identity,
    STATUS_LABEL       varchar(50)  not null,
    STATUS_DESCRIPTION varchar(100) not null,
    constraint PK_STATUS primary key (STATUS_ID)
)
go

/*==============================================================*/
/* Table : STRATEGY                                             */
/*==============================================================*/
create table STRATEGY
(
    STRATEGY_ID            numeric identity,
    USER_EMAIL             varchar(60) not null,
    STATUS_ID              numeric     not null,
    STRATEGY_LABEL         varchar(50) not null,
    STRATEGY_DESCRIPTION   text        null,
    STRATEGY_SYMBOL1       varchar(10) not null,
    STRATEGY_SYMBOL2       varchar(10) not null,
    STRATEGY_PRIME         float       not null,
    STRATEGY_ICON          varchar(10) null,
    STRATEGY_CREATION_DATE datetime    not null,
    STRATEGY_UPDATE_DATE   datetime    not null,
    constraint PK_STRATEGY primary key (STRATEGY_ID)
)
go

/*==============================================================*/
/* Index : MANAGE_STRAT_FK                                      */
/*==============================================================*/




create nonclustered index MANAGE_STRAT_FK on STRATEGY (USER_EMAIL ASC)
go

/*==============================================================*/
/* Index : SET_STATUS_STRATEGY_FK                               */
/*==============================================================*/




create nonclustered index SET_STATUS_STRATEGY_FK on STRATEGY (STATUS_ID ASC)
go

/*==============================================================*/
/* Table : TRADE                                                */
/*==============================================================*/
create table TRADE
(
    TRADE_ORDERLISTID         numeric identity,
    USER_EMAIL                varchar(60) not null,
    STATUS_ID                 numeric     not null,
    TRADE_PLATFORM            varchar(50) not null,
    TRADE_AMOUNT_SYMBOL1      float       not null,
    TRADE_AMOUNT_SYMBOL2      float       not null,
    TRADE_PAIR_LIMIT          float       null,
    TRADE_AMOUNT_LIMIT        float       null,
    TRADE_SYMBOL              varchar(30) not null,
    TRADE_CLIENTORDERLIST     varchar(50) null,
    TRADE_TRANSACTIME         bigint      not null,
    TRADE_PRICE               varchar(50) null,
    TRADE_ORIGQTY             varchar(50) null,
    TRADE_CUMMULATIVEQUOTEQTY varchar(50) null,
    TRADE_STATUS              varchar(50) null,
    TRADE_TIMEINFORCE         varchar(50) null,
    TRADE_TYPE                varchar(50) not null,
    TRADE_SIDE                varchar(50) not null,
    TRADE_CREATION_DATE       datetime    not null,
    TRADE_UPDATE_DATE         datetime    not null,
    constraint PK_TRADE primary key (TRADE_ORDERLISTID)
)
go

/*==============================================================*/
/* Index : MANAGE_TRADE_FK                                      */
/*==============================================================*/




create nonclustered index MANAGE_TRADE_FK on TRADE (USER_EMAIL ASC)
go

/*==============================================================*/
/* Index : SET_STATUS_TRADE_FK                                  */
/*==============================================================*/




create nonclustered index SET_STATUS_TRADE_FK on TRADE (STATUS_ID ASC)
go

/*==============================================================*/
/* Table : USER_DATA                                            */
/*==============================================================*/
create table USER_DATA
(
    USER_EMAIL        varchar(60)  not null,
    STATUS_ID         numeric      not null,
    USER_PASSWORD     varchar(30)  not null,
    USER_USERNAME     varchar(30)  not null,
    USER_FIRSTNAME    varchar(30)  null,
    USER_LASTNAME     varchar(30)  null,
    USER_BIRTHDATE    datetime     null,
    USER_SIGNIN       datetime     not null,
    USER_DESCRIPTION  text         null,
    USER_LINK_CONTACT varchar(100) null,
    USER_GAZ          float        null,
    USER_TOKEN        varchar(60)  null,
    USER_USING2FA     BIT          null,
    USER_SECRET       varchar(30)  null,
    USER_ENABLED      BIT          null,
    constraint PK_USER_DATA primary key (USER_EMAIL)
)
go

/*==============================================================*/
/* Index : SET_STATUS_USER_FK                                   */
/*==============================================================*/




create nonclustered index SET_STATUS_USER_FK on USER_DATA (STATUS_ID ASC)
go

/*==============================================================*/
/* Table : USER_PROFIL                                          */
/*==============================================================*/
create table USER_PROFIL
(
    USER_EMAIL varchar(60) not null,
    PROFIL_ID  numeric     not null,
    constraint PK_USER_PROFIL primary key (USER_EMAIL, PROFIL_ID)
)
go

/*==============================================================*/
/* Index : HAVE2_FK                                             */
/*==============================================================*/




create nonclustered index HAVE2_FK on USER_PROFIL (PROFIL_ID ASC)
go

/*==============================================================*/
/* Table : USER_SUBSCRIBE_STRAT                                 */
/*==============================================================*/
create table USER_SUBSCRIBE_STRAT
(
    STRATEGY_ID                numeric     not null,
    USER_EMAIL                 varchar(60) not null,
    PRIME_SOLIDR               float       not null,
    PRIME_EXPERT               float       not null,
    SUBSCRIBE_STRAT_START_DATE datetime    not null,
    SUBSCRIBE_STRAT_END_DATE   datetime    null,
    constraint PK_USER_SUBSCRIBE_STRAT primary key (STRATEGY_ID, USER_EMAIL)
)
go

/*==============================================================*/
/* Index : SUBSCRIBE_STRAT2_FK                                  */
/*==============================================================*/




create nonclustered index SUBSCRIBE_STRAT2_FK on USER_SUBSCRIBE_STRAT (USER_EMAIL ASC)
go

/*==============================================================*/
/* Table : WALLET                                               */
/*==============================================================*/
create table WALLET
(
    WALLET_ID             numeric identity,
    USER_EMAIL            varchar(60) not null,
    WALLET_BALANCE_SYMBOL varchar(10) not null,
    WALLET_BALANCE_TOTAL  float       not null,
    constraint PK_WALLET primary key (WALLET_ID)
)
go

/*==============================================================*/
/* Table : WALLET_HISTORY                                       */
/*==============================================================*/
create table WALLET_HISTORY
(
    WALLET_HISTORY_ID     numeric identity,
    WALLET_ID             numeric     not null,
    WALLET_HISTORY_DATE   datetime    not null,
    WALLET_HISTORY_SYMBOL varchar(10) not null,
    WALLET_HISTORY_TOTAL  float       not null,
    constraint PK_WALLET_HISTORY primary key (WALLET_HISTORY_ID)
)
go

/*==============================================================*/
/* Index : SAVE_WALLET_HISTORY_FK                               */
/*==============================================================*/




create nonclustered index SAVE_WALLET_HISTORY_FK on WALLET_HISTORY (WALLET_ID ASC)
go

alter table COMMENT
    add constraint FK_COMMENT_CONTAIN_C_STRATEGY foreign key (STRATEGY_ID)
        references STRATEGY (STRATEGY_ID)
go

alter table COMMENT
    add constraint FK_COMMENT_MANAGE_CO_USER_DAT foreign key (USER_EMAIL)
        references USER_DATA (USER_EMAIL)
go

alter table COMMENT
    add constraint FK_COMMENT_SET_STATU_STATUS foreign key (STATUS_ID)
        references STATUS (STATUS_ID)
go

alter table PROFIL_FONCTION
    add constraint FK_PROFIL_F_PROFIL_FO_PROFIL foreign key (PROFIL_ID)
        references PROFIL (PROFIL_ID)
go

alter table PROFIL_FONCTION
    add constraint FK_PROFIL_F_PROFIL_FO_FONCTION foreign key (FONCTION_ID)
        references FONCTION (FONCTION_ID)
go

alter table STRATEGY
    add constraint FK_STRATEGY_MANAGE_ST_USER_DAT foreign key (USER_EMAIL)
        references USER_DATA (USER_EMAIL)
go

alter table STRATEGY
    add constraint FK_STRATEGY_SET_STATU_STATUS foreign key (STATUS_ID)
        references STATUS (STATUS_ID)
go

alter table TRADE
    add constraint FK_TRADE_MANAGE_TR_USER_DAT foreign key (USER_EMAIL)
        references USER_DATA (USER_EMAIL)
go

alter table TRADE
    add constraint FK_TRADE_SET_STATU_STATUS foreign key (STATUS_ID)
        references STATUS (STATUS_ID)
go

alter table USER_DATA
    add constraint FK_USER_DAT_SET_STATU_STATUS foreign key (STATUS_ID)
        references STATUS (STATUS_ID)
go

alter table USER_PROFIL
    add constraint FK_USER_PRO_USER_PROF_USER_DAT foreign key (USER_EMAIL)
        references USER_DATA (USER_EMAIL)
go

alter table USER_PROFIL
    add constraint FK_USER_PRO_USER_PROF_PROFIL foreign key (PROFIL_ID)
        references PROFIL (PROFIL_ID)
go

alter table USER_SUBSCRIBE_STRAT
    add constraint FK_USER_SUB_USER_SUBS_STRATEGY foreign key (STRATEGY_ID)
        references STRATEGY (STRATEGY_ID)
go

alter table USER_SUBSCRIBE_STRAT
    add constraint FK_USER_SUB_USER_SUBS_USER_DAT foreign key (USER_EMAIL)
        references USER_DATA (USER_EMAIL)
go

alter table WALLET
    add constraint FK_WALLET_OWN_USER_DAT foreign key (USER_EMAIL)
        references USER_DATA (USER_EMAIL)
go

alter table WALLET_HISTORY
    add constraint FK_WALLET_H_SAVE_WALL_WALLET foreign key (WALLET_ID)
        references WALLET (WALLET_ID)
go

