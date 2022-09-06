-- phpMyAdmin SQL Dump
-- version 5.1.1
-- SQLINES DEMO *** admin.net/
--
-- SQLINES DEMO *** .0.1
-- SQLINES DEMO *** tạo: Th8 18, 2022 lúc 05:39 PM
-- SQLINES DEMO ***  phục vụ: 10.4.21-MariaDB
-- SQLINES DEMO ***  8.0.12

/* SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO"; */

/* SQLINES DEMO *** ARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/* SQLINES DEMO *** ARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/* SQLINES DEMO *** LLATION_CONNECTION=@@COLLATION_CONNECTION */;
/* SQLINES DEMO *** tf8mb4 */;

--
-- SQLINES DEMO *** ��u: `quan_ly_dan_cu`
--
CREATE DATABASE [quan_ly_dan_cu]
USE [quan_ly_dan_cu]

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** g cho bảng `giadinh`
--

DROP TABLE IF EXISTS [giadinh];
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE giadinh (
  [id] int NOT NULL,
  [idhokhau] int NOT NULL,
  [idnhankhau] int NOT NULL,
  [quanhechuho] varchar(20) NOT NULL
)  ;

--
-- SQLINES DEMO *** liệu cho bảng `giadinh`
--

-- SQLINES LICENSE FOR EVALUATION USE ONLY
INSERT INTO giadinh ([id], [idhokhau], [idnhankhau], [quanhechuho]) VALUES
(74, 26, 101, 'chủ hộ'),
(75, 26, 102, 'vợ'),
(77, 26, 104, 'con gái'),
(80, 27, 107, 'chủ hộ'),
(81, 27, 108, 'vợ'),
(82, 27, 109, 'con trai'),
(83, 27, 110, 'con gái'),
(84, 26, 112, 'con gái'),
(86, 27, 114, 'bố'),
(93, 29, 103, 'chủ hộ'),
(94, 29, 105, 'vợ'),
(95, 29, 106, 'con trai'),
(97, 30, 115, 'chủ hộ');

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** g cho bảng `hokhau`
--

DROP TABLE IF EXISTS [hokhau];
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE hokhau (
  [id] int NOT NULL,
  [mahokhau] varchar(20) NOT NULL,
  [cmndchuho] varchar(20) NOT NULL,
  [diachi] varchar(100) DEFAULT NULL,
  [ngaylap] date DEFAULT current_timestamp,
  [ngaychuyendi] date DEFAULT NULL,
  [tinhtrang] varchar(20) NOT NULL
)  ;

--
-- SQLINES DEMO *** liệu cho bảng `hokhau`
--

-- SQLINES LICENSE FOR EVALUATION USE ONLY
INSERT INTO hokhau ([id], [mahokhau], [cmndchuho], [diachi], [ngaylap], [ngaychuyendi], [tinhtrang]) VALUES
(26, 'HK1', '123123123123', 'HN', '2021-12-13', NULL, 'sinh sống'),
(27, 'HK27', '789456123123', 'HN', '2021-12-13', NULL, 'sinh sống'),
(29, 'HK28', '789789789789', 'HN', '2021-12-17', NULL, 'sinh sống'),
(30, 'HK30', '777777888888', 'HN', '2021-12-17', NULL, 'sinh sống');

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** g cho bảng `nhankhau`
--

DROP TABLE IF EXISTS [nhankhau];
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE nhankhau (
  [id] int NOT NULL,
  [hoten] varchar(100) NOT NULL,
  [bidanh] varchar(100) DEFAULT NULL,
  [ngaysinh] date NOT NULL,
  [gioitinh] varchar(10) NOT NULL,
  [noisinh] varchar(100) DEFAULT NULL,
  [nguyenquan] varchar(100) DEFAULT NULL,
  [dchiennay] varchar(100) DEFAULT NULL,
  [dantoc] varchar(20) DEFAULT NULL,
  [tongiao] varchar(50) DEFAULT NULL,
  [quoctich] varchar(50) DEFAULT NULL,
  [nghenghiep] varchar(50) DEFAULT NULL,
  [noilamviec] varchar(50) DEFAULT NULL,
  [cmnd] varchar(20) NOT NULL,
  [ngaycap] date DEFAULT NULL,
  [noicap] varchar(100) DEFAULT NULL,
  [ngaychuyenden] date DEFAULT NULL,
  [noitruocchuyenden] varchar(100) DEFAULT NULL,
  [ngaychuyendi] date DEFAULT NULL,
  [noiden] varchar(100) DEFAULT NULL,
  [tinhtrang] varchar(100) DEFAULT NULL,
  [tungay] date DEFAULT NULL,
  [denngay] date DEFAULT NULL,
  [ngaylap] date DEFAULT NULL
)  ;

--
-- SQLINES DEMO *** liệu cho bảng `nhankhau`
--

-- SQLINES LICENSE FOR EVALUATION USE ONLY
INSERT INTO nhankhau ([id], [hoten], [bidanh], [ngaysinh], [gioitinh], [noisinh], [nguyenquan], [dchiennay], [dantoc], [tongiao], [quoctich], [nghenghiep], [noilamviec], [cmnd], [ngaycap], [noicap], [ngaychuyenden], [noitruocchuyenden], [ngaychuyendi], [noiden], [tinhtrang], [tungay], [denngay], [ngaylap]) VALUES
(101, 'Nguyễn Văn A', '', '1967-03-20', 'Nam', 'HN', 'HN', 'HN', 'Kinh', 'không', 'VN', 'chủ tịch', 'HN', '123123123123', '2017-12-13', 'HN', '1967-03-20', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(102, 'Đỗ Thị B', '', '1969-07-13', 'Nữ', 'HP', 'HP', 'HN', 'Kinh', 'không', 'VN', 'nội trợ', 'HN', '456456456456', '2017-12-13', 'HN', '1987-12-30', 'HP', '2021-12-13', 'Qua đời. Khai tử bởi: Nguyễn Văn A - 123123123123 - ', 'đã mất', NULL, NULL, '2021-12-13'),
(103, 'Nguyễn Văn C', '', '1989-05-13', 'Nam', 'HN', 'HN', 'HN', 'kinh', 'không', 'VN', 'giám đốc', 'HN', '789789789789', '2017-12-13', 'HN', '1989-05-13', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(104, 'Nguyễn Thị D', '', '1993-02-04', 'Nữ', 'HN', 'Hn', 'HCM', 'Kinh', 'không', 'VN', 'giám đốc', 'HN', '123456789123', '2017-12-13', 'HN', '1993-02-04', 'HN', '4900-02-01', NULL, 'tạm vắng', '2021-12-03', '2021-12-16', '2021-12-13'),
(105, 'Hoàng Thị E', '', '1991-06-06', 'Nữ', 'HCM', 'HCM', 'HN', 'Kinh', 'không', 'VN', 'thư ký', 'HN', '123456789456', '2017-12-13', 'HCM', '2012-12-13', 'HCM', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(106, 'Nguyễn Văn F', '', '2018-12-13', 'Nam', 'HN', 'HN', 'HN', 'kinh', 'không', 'VN', 'mới sinh', 'mới sinh', '123456789789', NULL, '', '2018-12-13', 'mới sinh', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(107, 'Bùi Văn G', '', '1985-06-09', 'Nam', 'HD', 'HD', 'HN', 'kinh', 'không', 'VN', 'kỹ sư', 'HN', '789456123123', '2018-12-13', 'HD', '2008-12-13', 'HD', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(108, 'Trần Thị H', '', '1985-12-13', 'Nữ', 'HD', 'HD', 'HN', 'kinh', 'không', 'VN', 'kế toán', 'HN', '123456789777', '2017-12-13', 'HD', '2008-12-13', 'HD', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(109, 'Bùi Văn K', '', '2006-12-13', 'Nam', 'HN', 'HD', 'HN', 'kinh', 'không', 'VN', 'học sinh', 'HN', '123456789888', NULL, '', '2006-12-13', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(110, 'Bùi Thị I', '', '2008-12-13', 'Nữ', 'HN', 'HD', 'HN', 'kinh', 'không', 'VN', 'học sinh', 'HN', '123456789999', NULL, '', '2008-12-13', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(111, 'Trần Đức J', NULL, '1995-12-13', 'Nam', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '123456789666', NULL, NULL, NULL, 'BG', NULL, NULL, 'tạm trú', '2021-12-03', '2021-12-18', '2021-12-13'),
(112, 'Nguyễn Thị D', '', '1993-02-04', 'Nữ', 'HN', 'Hn', 'HN', 'Kinh', 'không', 'VN', 'giám đốc', 'HN', '123456789123', '2017-12-13', 'HN', '1993-02-04', 'HN', '2021-12-17', 'HCM', 'chuyển đi', '2021-12-03', NULL, '2021-12-13'),
(114, 'Bùi Văn L', '', '1967-12-17', 'Nam', 'HD', 'HD', 'HN', 'kinh', 'không', 'Vn', 'bảo vệ', 'HN', '111111111111', '2017-12-17', 'HN', '2012-12-17', 'HD', '2021-12-17', 'Qua đời. Khai tử bởi: Bùi Văn G - 789456123123 - 2554564564565rn', 'đã mất', '2021-12-20', NULL, '2021-12-17'),
(115, 'Nguyễn Văn R', '', '1990-12-17', 'Nam', 'HN', 'HN', 'HN', 'kinh', 'không', 'VN', 'giám đốc', 'HN', '777777888888', '2017-12-17', 'HN', '1990-12-17', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-17');

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** g cho bảng `thaydoihokhau`
--

DROP TABLE IF EXISTS [thaydoihokhau];
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE thaydoihokhau (
  [id] int NOT NULL,
  [mahokhau] varchar(20) NOT NULL,
  [ttintdoi] varchar(100) NOT NULL,
  [ndtdoi] varchar(100) DEFAULT NULL,
  [ghichu] varchar(100) DEFAULT NULL,
  [ngaytdoi] date DEFAULT current_timestamp
)  ;

--
-- SQLINES DEMO *** liệu cho bảng `thaydoihokhau`
--

-- SQLINES LICENSE FOR EVALUATION USE ONLY
INSERT INTO thaydoihokhau ([id], [mahokhau], [ttintdoi], [ndtdoi], [ghichu], [ngaytdoi]) VALUES
(10, 'HK1', 'Chuyển đến', NULL, NULL, '2021-12-13'),
(11, 'HK1', 'Thêm thành viên', 'Nguyễn Văn A - 123123123123', NULL, '2021-12-13'),
(12, 'HK1', 'Thêm thành viên', 'Đỗ Thị B - 456456456456', NULL, '2021-12-13'),
(13, 'HK1', 'Thêm thành viên', 'Nguyễn Văn C - 789789789789', NULL, '2021-12-13'),
(14, 'HK1', 'Thêm thành viên', 'Nguyễn Thị D - 123456789123', NULL, '2021-12-13'),
(15, 'HK1', 'Thêm thành viên', 'Hoàng Thị E - 123456789456', NULL, '2021-12-13'),
(16, 'HK1', 'Thêm thành viên', 'Nguyễn Văn F - 123456789789', NULL, '2021-12-13'),
(17, 'HK27', 'Chuyển đến', NULL, NULL, '2021-12-13'),
(18, 'HK27', 'Thêm thành viên', 'Bùi Văn G - 789456123123', NULL, '2021-12-13'),
(19, 'HK27', 'Thêm thành viên', 'Trần Thị H - 123456789777', NULL, '2021-12-13'),
(20, 'HK27', 'Thêm thành viên', 'Bùi Văn K - 123456789888', NULL, '2021-12-13'),
(21, 'HK27', 'Thêm thành viên', 'Bùi Thị I - 123456789999', NULL, '2021-12-13'),
(22, 'HK1', 'Xóa thành viên', 'Đỗ Thị B - 456456456456', 'Qua đời. Khai tử bởi: Nguyễn Văn A - 123123123123 - ', '2021-12-13'),
(23, 'HK1', 'Xóa thành viên', 'Nguyễn Thị D - 123456789123', 'Chuyển đến HCM', '2021-12-17'),
(24, 'HK27', 'Thêm thành viên', 'Bùi Văn L - 111111111111', NULL, '2021-12-17'),
(26, 'HK27', 'Xóa thành viên', 'Bùi Văn L - 111111111111', 'Qua đời. Khai tử bởi: Bùi Văn G - 789456123123 - ', '2021-12-17'),
(27, 'HK28', 'Chuyển đến', NULL, NULL, '2021-12-17'),
(28, 'HK1', 'Xóa thành viên', 'Nguyễn Văn C - 789789789789', 'Chuyển đến hộ HK28', '2021-12-17'),
(29, 'HK28', 'Thêm thành viên', 'Nguyễn Văn C - 789789789789', NULL, '2021-12-17'),
(30, 'HK1', 'Xóa thành viên', 'Hoàng Thị E - 123456789456', 'Chuyển đến hộ HK28', '2021-12-17'),
(31, 'HK28', 'Thêm thành viên', 'Hoàng Thị E - 123456789456', NULL, '2021-12-17'),
(32, 'HK1', 'Xóa thành viên', 'Nguyễn Văn F - 123456789789', 'Chuyển đến hộ HK28', '2021-12-17'),
(33, 'HK28', 'Thêm thành viên', 'Nguyễn Văn F - 123456789789', NULL, '2021-12-17'),
(34, 'HK1', 'Thêm thành viên', 'Nguyễn Văn R - 777777888888', NULL, '2021-12-17'),
(35, 'HK30', 'Chuyển đến', NULL, NULL, '2021-12-17'),
(36, 'HK1', 'Xóa thành viên', 'Nguyễn Văn R - 777777888888', 'Chuyển đến hộ HK30', '2021-12-17'),
(37, 'HK30', 'Thêm thành viên', 'Nguyễn Văn R - 777777888888', '', '2021-12-17');

-- SQLINES DEMO *** ---------------------------------------

--
-- SQLINES DEMO *** g cho bảng `users`
--

DROP TABLE IF EXISTS [users];
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE users (
  [id] int NOT NULL,
  [username] varchar(20) NOT NULL,
  [pass] varchar(20) NOT NULL
)  ;

--
-- SQLINES DEMO *** liệu cho bảng `users`
--

-- SQLINES LICENSE FOR EVALUATION USE ONLY
INSERT INTO users ([id], [username], [pass]) VALUES
(1, 'admin1', 'admin'),
(2, 'admin2', 'admin');

--
-- SQLINES DEMO *** ác bảng đã đổ
--

--
-- SQLINES DEMO *** ảng `giadinh`
--
ALTER TABLE giadinh ADD PRIMARY KEY ([id])
  
ALTER TABLE giadinh ADD FOREIGN KEY (idhokhau) REFERENCES hokhau(id)

ALTER TABLE giadinh ADD FOREIGN KEY (idnhankhau) REFERENCES nhankhau(id)

--
-- SQLINES DEMO *** ảng `hokhau`
--
ALTER TABLE hokhau ADD PRIMARY KEY ([id])
  
--????
ALTER TABLE hokhau ADD KEY dbo.`mahokhau` ([mahokhau])
ADD KEY dbo.`mahokhau` ([mahokhau]),
ADD KEY dbo.`cmndchuho` ([cmndchuho]);

--
-- SQLINES DEMO *** ảng `nhankhau`
--
ALTER TABLE nhankhau ADD PRIMARY KEY ([id])

--???
  ADD KEY dbo.`cmnd` ([cmnd]);

--
-- SQLINES DEMO *** ảng `thaydoihokhau`
--
ALTER TABLE thaydoihokhau ADD PRIMARY KEY ([id])

---???
  ADD KEY dbo.`mahokhau` ([mahokhau]);

--
-- SQLINES DEMO *** ảng `users`
--
ALTER TABLE users ADD PRIMARY KEY ([id])

--
-- SQLINES DEMO *** o các bảng đã đổ
--

--
-- SQLINES DEMO *** o bảng `giadinh`
--
ALTER TABLE giadinh
  MODIFY [id] cast(11 as int) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;
 
--ALTER TABLE giadinh 
--ALTER COLUMN [id] [int] IDENTITY(1,1) NOT NULL

--
-- SQLINES DEMO *** o bảng `hokhau`
--
ALTER TABLE hokhau
  MODIFY [id] cast(11 as int) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- SQLINES DEMO *** o bảng `nhankhau`
--
ALTER TABLE nhankhau
  MODIFY [id] cast(10 as int) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- SQLINES DEMO *** o bảng `thaydoihokhau`
--
ALTER TABLE thaydoihokhau
  MODIFY [id] cast(11 as int) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- SQLINES DEMO *** o bảng `users`
--
ALTER TABLE users
  MODIFY [id] cast(10 as int) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- SQLINES DEMO ***  cho các bảng đã đổ
--

--
-- SQLINES DEMO ***  cho bảng `giadinh`
--
ALTER TABLE giadinh ADD CONSTRAINT [giadinh_ibfk_1] FOREIGN KEY ([idhokhau]) REFERENCES hokhau ([id])
ALTER TABLE giadinh  ADD CONSTRAINT [giadinh_ibfk_2] FOREIGN KEY ([idnhankhau]) REFERENCES nhankhau ([id])

--
-- SQLINES DEMO ***  cho bảng `hokhau`
--
ALTER TABLE hokhau ADD CONSTRAINT [hokhau_ibfk_1] FOREIGN KEY ([cmndchuho]) REFERENCES nhankhau ([cmnd])

--
-- SQLINES DEMO ***  cho bảng `thaydoihokhau`
--
ALTER TABLE thaydoihokhau ADD CONSTRAINT [thaydoihokhau_ibfk_1] FOREIGN KEY ([mahokhau]) REFERENCES hokhau ([mahokhau]);
COMMIT;

/* SQLINES DEMO *** ER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/* SQLINES DEMO *** ER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/* SQLINES DEMO *** ON_CONNECTION=@OLD_COLLATION_CONNECTION */;
