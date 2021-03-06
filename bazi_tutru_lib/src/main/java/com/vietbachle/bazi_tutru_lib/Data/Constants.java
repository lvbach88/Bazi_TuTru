package com.vietbachle.bazi_tutru_lib.Data;

/**
 * Created by vietbachle on 2/4/2017.
 */

public class Constants {

    public static int THIEN_CAN_SIZE = 10;
    public static int DIA_CHI_SIZE = 12;

    public static String NAP_AM = "NAP_AM";
    public static String VONG_TRUONG_SINH = "VONG_TRUONG_SINH";

    public static String TRU_NGAY = "NGAY";
    public static String TRU_GIO = "GIO";
    public static String TRU_THANG = "THANG";
    public static String TRU_NAM = "NAM";
    public static String CUNG_MENH = "CUNG MENH";
    public static String THAI_NGUYEN = "THAI NGUYEN";

    public static int SO_DAI_VAN = 9;
    public static int NAM_DAI_VAN = 10;
    public static int SO_TIEU_VAN = SO_DAI_VAN * NAM_DAI_VAN;


    public static int SEEDING_YEAR = 2015;
    public static CanEnum SEEDING_CAN = CanEnum.At;
    public static ChiEnum SEEDING_CHI = ChiEnum.Mui;

    public static int CUNG_MENH_SHIFT = -1;
    public static int CUNG_MENH_LOWER_BOUND = 14;
    public static int CUNG_MENH_UPPER_BOUND = 26;

    public static int THAI_NGUYEN_CAN_SHIFT = 1;
    public static int THAI_NGUYEN_CHI_SHIFT = 3;

    public static class CungMenhSao
    {
        public static String CUNG_MENH_SAO = "CUNG_MENH_SAO";
        public static String THIEN_QUY = "THIEN_QUY";
        public static String THIEN_ACH = "THIEN_ACH";
        public static String THIEN_QUYEN = "THIEN_QUYEN";
        public static String THIEN_XICH = "THIEN_XICH";
        public static String THIEN_NHU = "THIEN_NHU";
        public static String THIEN_VAN = "THIEN_VAN";
        public static String THIEN_PHUC = "THIEN_PHUC";
        public static String THIEN_LAO = "THIEN_LAO";
        public static String THIEN_QUA = "THIEN_QUA";
        public static String THIEN_BI = "THIEN_BI";
        public static String THIEN_NGHE = "THIEN_NGHE";
        public static String THIEN_THO = "THIEN_THO";
    }

    public static class ThuocTinh
    {
//        #region Luc Hop
        public static String LUC_HOP_SINH = "LUC_HOP_SINH";
        public static String LUC_HOP_KHAC = "LUC_HOP_KHAC";
//        #endregion Luc Hop

        public static String LUC_XUNG = "LUC_XUNG";

        public static String LUC_HAI = "LUC_HAI";

//        #region Tam Hoi
        public static String TAM_HOI = "TAM_HOI";
        public static String BAN_TAM_HOI = "BAN_TAM_HOI";
//        #endregion Tam Hoi

//        #region Tam Hop
        public static String TAM_HOP = "TAM_HOP";
        public static String BAN_TAM_HOP = "BAN_TAM_HOP";
//        #endregion Tam Hop

//        #region Tuong Hinh
        public static String TU_HINH = "TU_HINH";
        public static String NHI_HINH = "NHI_HINH";
        public static String TAM_HINH = "TAM_HINH";

//        #endregion Tuong Hinh

        public static String TUONG_LIEN = "TUONG_LIEN";

        public static String THIEN_CAN_NGU_HOP = "NGU_HOP";
    }

    public static class ThanSat
    {
        public static String THIEN_AT_QUY_NHAN = "THIEN_AT_QUY_NHAN";
        public static String THIEN_DUC = "THIEN_DUC";
        public static String NGUYET_DUC = "NGUYET_DUC";
        public static String KHOI_CANH_QUY_NHAN = "KHOI_CANH_QUY_NHAN";
        public static String LOC_THAN = "LOC_THAN";
        public static String KINH_DUONG = "KINH_DUONG";
        public static String KIM_DU = "KIM_DU";
        public static String VAN_XUONG = "VAN_XUONG";
        public static String THIEN_Y = "THIEN_Y";
        public static String DICH_MA = "DICH_MA";
        public static String HOA_CAI = "HOA_CAI";
        public static String TUONG_TINH = "TUONG_TINH";
        public static String DAO_HOA = "DAO_HOA";
        public static String DAO_HOA_SAT = "DAO_HOA_SAT";
        public static String KIEP_SAT = "KIEP_SAT";
        public static String KHONG_VONG = "KHONG_VONG";
        public static String THIEN_XA = "THIEN_XA";
        public static String HOC_DUONG = "HOC_DUONG";
        public static String TU_QUAN = "TU_QUAN";
        public static String KIM_THAN = "KIM_THAN";
        public static String NGUYEN_THAN = "NGUYEN_THAN";
        public static String TAI_SAT = "TAI_SAT";
        public static String QUOC_AN = "QUOC_AN";
        public static String THIEN_LA = "THIEN_LA";
        public static String DIA_VONG = "DIA_VONG";
        public static String CAU = "CAU";
        public static String GIAO = "GIAO";
        public static String CO_THAN = "CO_THAN";
        public static String QUA_TU = "QUA_TU";
        public static String THAP_AC_DAI_BAI = "THAP_AC_DAI_BAI";
        public static String AM_DUONG_SAI_THAC = "AM_DUONG_SAI_THAC";
        public static String THAI_CUC_QUY_NHAN = "THAI_CUC_QUY_NHAN";
        public static String DUC_THAN = "DUC_THAN";
        public static String CACH_GIAC = "CACH_GIAC";
    }

    public static class DiaChiLucHop
    {
        public static String LUC_HOP_KHAC = "TRONG HOP CO KHAC: Truoc tot ma sau xau, truoc nong ma sau lanh." +
                "Co the quan he vo chong hoac ban be, luc dau rat tot nhung sau do ly hon hoac tinh ban tan vo";
        public static String LUC_HOP_SINH = "TRONG HOP CO SINH: Quan he vo chong hay cac moi quan he xa hoi thi ngay cang tot dep hon";

        public static String GUIDELINES = "Luc hop, nam hop thi dep, nu hop thi da dam. Phu Nhan Ky Hop.";
    }

    public static class DiaChiLucXung
    {
        public static String TI_NGO = "Mot doi bat an. Thuong thay doi cho o nhung cong tac khong thay doi";
        public static String SUU_MUI = "Gap nhieu tro ngai. Chuc nghiep xung, gia canh yen on khong thay doi nhung cong tac thay doi.";
        public static String DAN_THAN = "Da tinh, doi viec khong dau.";
        public static String MAO_DAU= "Boi uoc that tin, lo nghi buon rau, tinh cam giay vo. " +
                "Thuong thay doi cho o nhung cong tac khong thay doi";
        public static String THIN_TUAT = "Khac nguoi than, hinh thuong con doan tho. " +
                "Chuc nghiep xung, gia canh yen on khong thay doi nhung cong tac thay doi.";
        public static String TY_HOI = "Doi viec khong dau, thich giup nguoi khac.";

        public static String GUIDELINES = "Dia chi luc xung, xung ky than thi tot, xung cat than, hy than la xau. " +
                "Nam xung thang: Song xa que nha. " +
                "Nam xung ngay: Nguoi than bat hoa. " +
                "Nam xung gio: Con khong hop. " +
                "Nam xung ngay, thang, gio: Tinh hung bao va co tat. " +
                "Ngay xung gio: Khac vo ton con. " +
                "Ngay xung thang: Pham cha me, anh em. " +
                "Tu tru gap xung thuong khong son chung voi cha me";
    }

    public static class DiaChiLucHai
    {
        public static String TI_MUI = "Anh em de bat hoa, khong giup do lan nhau, da thit kho khan";
        public static String SUU_NGO = "Neu gap Truong Sinh, De Vuong, Lam Quan thi la nguoi tinh hay gian doi, lam viec khong nhan nai, chong chan. " +
                "Neu gap Suy, Benh, Tu, Tuyet thi co the bi thuong den tan tat.";
        public static String DAN_TY = "Ve gia bi phe tat, neu trong tu tru nhieu Kim thi benh tat day than.";
        public static String MAO_THIN = "Neu gap Truong Sinh, De Vuong, Lam Quan thi la nguoi tinh hay gian doi, lam viec khong nhan nai, chong chan. " +
                "Neu gap Suy, Benh, Tu, Tuyet thi co the bi thuong den tan tat.";
        public static String THAN_HOI = "Xung khac ho hang, cam diec hoac co nhieu mun nhot, seo.";
        public static String DAU_TUAT = "Xung khac ho hang, cam diec hoac co nhieu mun nhot, seo. " +
                "Ngay Dau gio Tuat, ve gia co the bi cam diec, dau mat co seo";

        public static String GUIDELINES = "Thang hai cac chi khac: Khac vo con anh em, song co doc, bac menh. " +
                "Xau nhat la ngay gio tuong hai, ve gia tan tat khong noi nuong tua. " +
                "Neu gap Kinh Duong co the chet hoac gap tai hoa vi ten dan hay thu du.";
    }

    public static class DiaChiTamHoi
    {
        public static String TAM_HOI = "";
        public static String BAN_TAM_HOI = "";
    }

    public static class DiaChiTamHop
    {
        public static String TAM_HOP = "";
        public static String BAN_TAM_HOP = "";

        public static String GUIDELINES = "Kien Loc hop thuong nhieu tai san, van may ngoai y muon. " +
                "Neu la hop quy nhan Chinh An, thi duoc thien an vo cung tot. " +
                "Neu la hop Thuc Than, com an ao mac tai loc doi dao. " +
                "Neu la hop Nguyen Than Dai Hao, nguoi khong phep tac, noi thi cao sang ma hanh thi thap kem, gan tieu nhan xa quan tu. " +
                "Neu la hop Ham Tri, thuong la dam loan bat luong, pham tuc. " +
                "Tam hop, nam hop thi dep, nu hop thi da dam. Phu Nhan Ky Hop.";
    }

    public static class DiaChiTuongHinh
    {
        public static String TU_HINH = "Nguoi khong co tinh tu chu, dung mao tho kech. " +
                "Lam viec co dau co duoi nhung hay co chap, thuong roi vao hoan canh kho khan, noi tam hiem doc. " +
                "Neu Tu, Tuyet cung tru thi suy nghi nong noi. " +
                "Ngay sinh co Tu Hinh, vo chong co benh. " +
                "Gio sinh co hinh nay, con cai om dau";

        public static String NHI_HINH = "Thieu tinh doc lap tu chu, hanh dong thuong dau voi duoi chuot, co chap, thanh kien, thuong roi vao hoan canh kho khan, dung mao xau xi, noi tam ac doc, tinh tinh hung bao, khong biet le nghi, bat hoa voi moi nguoi, ban be ghet bo xa cach, bat hieu, hai den nguoi than. " +
                "Phu nu bi hinh nay bi chong khac che. Me con bat hoa de ton hai. " +
                "Ngay sinh gap hinh nay vo hoac chong co benh. " +
                "Gio sinh gap hinh nay con cai benh tat yeu duoi.";

        public static String DAN_TY_THAN = "Hinh vo on. Nguoi ma tu tru co hinh nay ma gap Tue Van tuong hinh: Tinh tinh tho bao, bac nghia hoac roi vao hiem hoa, hai nguoi. " +
                "Neu lai toa o Tu Tuyet thi rat xau, hay gap benh tat, tai uong. " +
                "Nu phai song co qua, de ton thai. " +
                "Menh quy thi hieu sat, thich cong danh. " +
                "Menh tien thi loi noi va viec lam trai nguoc, tham lam";

        public static String SUU_TUAT_MUI = "Hinh cay the. Nguoi ma co tu tru nay la cay the ban than qua manh me, de gap do vo, thap bai. " +
                "Neu gap Truong Sinh, Moc Duc, Quan Doi, Lam Quan, De Vuong, tinh tinh cuong truc. " +
                "Neu gap Tu Tuyet, ti tien giao hoat, thuong co benh de gay tai hoa. " +
                "Nu phai song co doc. " +
                "Menh quy thi thanh liem chinh truc. " +
                "Menh tien thi hay pham phap, bi hinh phat.";


        public static String GUIDELINES = "Tu tru co 2 to tu hinh cang xau. Menh tu tru dep la khong co Tu Hinh. " +
                "Luu y: Tu Hinh chi khi 2 chu dung ke nhau, cach nhau khong tinh.";
    }

    public static class DiaChiTuongLien
    {
        public static int SO_TUONG_LIEN = 3;

        public static String TAM_TI = "Nang ve hon nhan nhieu trac tro.";
        public static String TAM_SUU = "Co nhieu vo.";
        public static String TAM_DAN = "Song 1 minh.";

        public static String TAM_MAO = "Gian ac.";
        public static String TAM_TY = "Hinh va hai.";
        public static String TAM_NGO = "Khac vo.";

        public static String TAM_MUI = "Dinh khong vong.";
        public static String TAM_THAN = "Nguoi khuyet tat.";
        public static String TAM_DAU = "Song co doc.";
        public static String TAM_HOI = "Song 1 minh.";
    }
}

