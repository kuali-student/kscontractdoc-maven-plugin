TRUNCATE TABLE KSCO_COMMENT DROP STORAGE
/
INSERT INTO KSCO_COMMENT (EFF_DT,EXPIR_DT,ID,REFERENCE,RT_DESCR_ID,STATE,TYPE,VERSIONIND)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),TO_DATE( '20001231000000', 'YYYYMMDDHH24MISS' ),'COMMENT-1','1234567ASDF','RT-DESC-COMMENT-1','Active','commentType.type1',0)
/
INSERT INTO KSCO_COMMENT (EFF_DT,EXPIR_DT,ID,REFERENCE,RT_DESCR_ID,STATE,TYPE,VERSIONIND)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),TO_DATE( '20001231000000', 'YYYYMMDDHH24MISS' ),'COMMENT-2','1234567ASDF','RT-DESC-COMMENT-1','Active','commentType.type1',0)
/
INSERT INTO KSCO_COMMENT (EFF_DT,EXPIR_DT,ID,REFERENCE,RT_DESCR_ID,STATE,TYPE,VERSIONIND)
  VALUES (TO_DATE( '20000101000000', 'YYYYMMDDHH24MISS' ),TO_DATE( '20001231000000', 'YYYYMMDDHH24MISS' ),'COMMENT-3','1234568ASDF','RT-DESC-COMMENT-1','Active','commentType.type2',0)
/