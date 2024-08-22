package com.project.server.infrastructure.exception.custom;

public final class ErrorConstants {

    public static final String USER_NOT_EXIST = "Người dùng không tồn tại";

    public static final String USER_WALLET_NOT_EXIST = "Ví của người dùng không tồn tại";

    public static final String COIN_NOT_EXIST = "Coin không tồn tại";

    public static final String COIN_EXISTS = "Coin đã tồn tại";

    public static final String EMAIL_OR_PASSWORD_INCORRECT = "Tài khoản hoặc mật khẩu không chính xác";

    public static final String USER_EXISTS = "Email này đã tồn tại";

    public static final String EMAIL_NAY_DA_GUI_YEU_CAU_DANG_KY = "Email này đã gửi yêu cầu đăng ký tài khoản";

    public static final String TAI_KHOAN_NAY_DA_TON_TAI_TRONG_HE_THONG = "Tài khoản này đã tồn tại trong hệ thống";

    public static final String NGUOI_DUNG_DA_SO_HUU_COIN_NAY = "Người dùng đã sở hữu coin này";

    public static final String BAN_CHUA_THIET_LAP_TY_GIA_HIEN_TAI = "Bạn chưa thiết lập tỷ giá hiện tại";

    public static final String MA_QUY_DA_TON_TAI = "Mã quỹ đã tồn tại";

    public static final String TEN_QUY_DA_TON_TAI = "Tên quỹ đã tồn tại";

    public static final String MA_NGUOI_DUNG_THUOC_QUY_DA_TON_TAI = "Mã người dùng thuộc quỹ đã tồn tại";

    public static final String KHONG_THE_CHINH_MA_NGUOI_DUNG_KHI_QUY_DA_CO_KHACH_HANG = "Không thể chỉnh mã người dùng khi quỹ đã có khách hàng";

    public static final String QUY_KHONG_TON_TAI = "Quỹ không tồn tại";

    public static final String USER_FUND_EXISTS = "Người dùng đã tham gia quỹ ";

    public static final String CATEGORY_KHONG_TON_TAI = "Phân loại không tồn loại";

    public static final String BAO_CAO_KHONG_TON_TAI = "Báo cáo không tồn tại";

    public static final String CATEGORY_DANG_DUOC_SU_DUNG = "Thể loại đang có coin thuộc vào, không thể xóa";

    public static final String PHONG_CACH_DAU_TU_KHONG_TON_TAI = "Phong cách đầu tư không tồn tại";

    public static final String PHONG_CACH_DAU_TU_DANG_CO_KHACH_HANG = "Đang có khách hàng theo phong cách đầu tư này. Không thể xóa";

    public static final String TAI_KHOAN_NAY_DANG_LAM_ADMIN = "Tài khoàn này đang làm quản trị viên";

    public static final String RECORD_NOT_FUND = "Không tìm thấy bản ghi phù hợp";

    public static final String INVALID_STATUS = "Trạng thái không hợp lệ";

    public static final String UNCERTAIN_ERROR = "Lỗi bất định vui lòng thử lại";

    public static final String OTP_IS_WRONG = "Mã OTP không đúng, vui lòng thử lại";

    public static final String OTP_EXPIRED = "Mã OTP đã hết hạn";

    public static final String RECORD_NOT_EXISTS = "Không tìm thấy bản ghi theo ID";

    public static final String BAN_CHUA_CO_MA_XAC_THUC = "Bạn chưa có mã xác thực";

    public static final String RECORD_PAYMENT_EXIST = "Loại phương thức hoặc thứ tự của phương thức bị trùng lặp với một phương thức đã tồn tại";

    public static final String REFER_CODE_NOT_EXIST = "Mã giới thiệu không tồn tại, vui lòng kiểm tra lại";

    public static final String USERNAME_NOT_FOUND = "Tài khoản của bạn không tồn tại trong hệ thống. Hãy đăng ký để có thể đăng nhập được vào hệ thống !";

    public static final String RECORD_APPROVED_OR_REJECTED = "Record has been approved or rejected, please reload the page";

    public static final String WALLET_ADDRESS_NOT_EXIST = "Bạn chưa có địa chỉ ví, vui lòng cập nhật địa chỉ ví của mình trong mục trang cá nhân";
    public static final String PAYMENT_METHOD_ERROR = "Các phương thức thanh toán khác chưa được hỗ trợ, vui lòng chọn phương thức Onchain";
    public static final String INVALID_MONEY = "Số tiền nạp vào không hợp lệ vui lòng kiểm tra lại";
}
