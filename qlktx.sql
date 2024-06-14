-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2024 lúc 09:10 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlktx`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `manager`
--

CREATE TABLE `manager` (
  `mid` varchar(10) NOT NULL,
  `mpass` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `manager`
--

INSERT INTO `manager` (`mid`, `mpass`) VALUES
('admin', '1'),
('admin1', '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `sid` varchar(10) NOT NULL,
  `sname` varchar(255) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `phonenumber` int(10) NOT NULL,
  `rid` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`sid`, `sname`, `sex`, `dob`, `phonenumber`, `rid`) VALUES
('23IT002', 'Đoàn Quang Tuấn An', 'male', '03/11/2005', 383614235, '1'),
('23IT008', 'Đoàn Việt Ân', 'male', '07/11/2005', 868421280, '1'),
('23IT015', 'Nguyễn Hoàng Nhật Bảo', 'male', '26/08/2005', 905550926, '1'),
('23IT019', 'Đặng Công Bằng', 'male', '04/09/2005', 332823108, '1'),
('23IT027', 'Trần Hữu Hoàng Châu', 'male', '23IT027', 559493515, '2'),
('23IT033', 'Nguyễn Mạnh Cường', 'male', '22/05/2005', 977148627, '2'),
('23IT049', 'Nguyễn Phú Đạt', 'male', '12/11/2005', 766708359, '2'),
('23IT054', 'Trương Công Tiến Đạt', 'male', '14/02/2004', 362191465, '2');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`mid`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`sid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
