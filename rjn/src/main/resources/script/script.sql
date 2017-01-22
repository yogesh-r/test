
CREATE TABLE IF NOT EXISTS `tx_billing_details` ( 
`detail_id` int(10) NOT NULL AUTO_INCREMENT, 
`bill_id` int(10) DEFAULT NULL, 
`booking_header_id` int(11) DEFAULT NULL, 
`line_type` varchar(10) NOT NULL DEFAULT 'BOOK', 
`tax_code_id` varchar(10) DEFAULT NULL, 
`booking_price` int(10) DEFAULT NULL, 
`tax_amount` int(10) NOT NULL DEFAULT '0', 
`book_amount` int(10) NOT NULL DEFAULT '0', 
`created_date` varchar(30) DEFAULT NULL, 
`last_update_date` varchar(30) DEFAULT NULL, 
`Status` varchar(30) NOT NULL DEFAULT 'Active', 
`line_description` varchar(240) DEFAULT NULL, 
`book_id` varchar(30) DEFAULT NULL, 
`booking_ref` varchar(60) DEFAULT NULL, 
`bill_ref_no` varchar(50) DEFAULT NULL, 
`book_line_ref` varchar(30) DEFAULT NULL, 
`Due_Units` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`detail_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_billing_master` ( 
`bill_id` int(10) NOT NULL AUTO_INCREMENT, 
`branch_id` varchar(30) NOT NULL, 
`booking_id` varchar(30) DEFAULT NULL, 
`bill_type` varchar(30) NOT NULL DEFAULT 'Invoice', 
`cust_profile_id` int(10) NOT NULL, 
`bill_date` varchar(30) NOT NULL, 
`payment_term_id` int(10) NOT NULL, 
`Bill_No` varchar(30) DEFAULT NULL, 
`Bill_Amount` double NOT NULL, 
`Tax_amount` double NOT NULL, 
`Status` varchar(30) DEFAULT NULL, 
`created_date` varchar(30) DEFAULT NULL, 
`last_update_date` varchar(30) DEFAULT NULL, 
`receipt_status` varchar(30) NOT NULL DEFAULT 'Un-Paid', 
`receipt_amount` int(30) NOT NULL DEFAULT '0', 
`Transaction_Type` varchar(30) NOT NULL DEFAULT 'Automatic', 
`cancel_reason` varchar(240) DEFAULT NULL, 
`Bill_Source` varchar(30) DEFAULT NULL, 
`cust_profile_no` varchar(50) NOT NULL, 
`booking_ref_nos` varchar(500) DEFAULT NULL, 
`receipt_ids` varchar(500) DEFAULT NULL, 
PRIMARY KEY (`bill_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_booking_enq` ( 
`Booking_enq_id` int(6) NOT NULL AUTO_INCREMENT, 
`Booking_enq_no` varchar(40) DEFAULT NULL, 
`Cust_profile_no` varchar(40) DEFAULT NULL, 
`branch_id` varchar(40) DEFAULT NULL, 
`Facility_type` varchar(40) DEFAULT NULL, 
`Book_for` varchar(40) DEFAULT NULL, 
`Floor` varchar(40) DEFAULT NULL, 
`Start_date` varchar(40) DEFAULT NULL, 
`End_date` varchar(40) DEFAULT NULL, 
`field_1` varchar(20) DEFAULT NULL, 
PRIMARY KEY (`Booking_enq_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_booking_header` ( 
`header_id` int(10) NOT NULL AUTO_INCREMENT, 
`booking_ref` varchar(100) DEFAULT NULL, 
`booking_date` varchar(60) DEFAULT NULL, 
`cust_profile_id` int(30) DEFAULT NULL, 
`gross_amount` int(30) DEFAULT NULL, 
`tax_code_id` varchar(30) DEFAULT '1', 
`tax_amount` int(30) DEFAULT NULL, 
`discount_amount` int(30) DEFAULT NULL, 
`actual_amount` int(30) DEFAULT NULL, 
`promo_code` varchar(60) DEFAULT NULL, 
`promo_id` varchar(60) DEFAULT NULL, 
`booking_status` varchar(60) DEFAULT NULL, 
`Advance_Type` varchar(30) DEFAULT NULL, 
`Advance_Value` int(30) DEFAULT NULL, 
`Advance_Amount` int(30) DEFAULT NULL, 
`Adv_Term_ID` varchar(30) DEFAULT NULL, 
`Pay_Date` varchar(30) DEFAULT NULL, 
`cancel_reason` varchar(250) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`receipt_ids` varchar(30) DEFAULT NULL, 
`received_amount` int(30) DEFAULT NULL, 
PRIMARY KEY (`header_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_booking_seat_details` ( 
`detail_id` int(10) NOT NULL AUTO_INCREMENT, 
`book_id` int(10) NOT NULL, 
`floor_id` varchar(60) DEFAULT NULL, 
`fac_id` varchar(20) NOT NULL, 
`seat_id` int(10) NOT NULL, 
`branch_id` int(6) NOT NULL, 
PRIMARY KEY (`detail_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_booking_transactions` ( 
`book_id` int(10) NOT NULL AUTO_INCREMENT, 
`header_id` varchar(50) DEFAULT NULL, 
`branch_id` varchar(50) NOT NULL, 
`category` varchar(50) NOT NULL, 
`fac_type` varchar(50) NOT NULL, 
`seats` int(5) NOT NULL, 
`units` int(5) NOT NULL, 
`start_date` varchar(30) DEFAULT NULL, 
`start_time` time NOT NULL, 
`email_id` varchar(40) DEFAULT NULL, 
`end_date` varchar(30) DEFAULT NULL, 
`end_time` varchar(30) DEFAULT NULL, 
`Seat_numbers` varchar(2000) DEFAULT NULL, 
`fac_id` varchar(100) DEFAULT NULL, 
`Price` int(30) DEFAULT NULL, 
`Amount` int(30) DEFAULT NULL, 
`Bill_line_id` varchar(30) DEFAULT NULL, 
`Billed_status` varchar(30) DEFAULT 'Un-Billed', 
`Billed_Amount` int(30) DEFAULT '0', 
`last_billed_date` varchar(30) DEFAULT NULL, 
`line_discount` int(30) DEFAULT '0', 
`line_net_pay` int(30) DEFAULT NULL, 
`booking_ref` varchar(30) DEFAULT NULL, 
`book_line_ref` varchar(30) DEFAULT NULL, 
`Checked_In_Date` varchar(50) DEFAULT NULL, 
`Checked_Out_date` varchar(50) DEFAULT NULL, 
`Checked_In_Time` varchar(50) DEFAULT NULL, 
`Checked_Out_Time` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`book_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_branch_feature_master` ( 
`feature_id` varchar(50) NOT NULL, 
`feature_name` varchar(50) NOT NULL, 
`branch_id` varchar(50) NOT NULL, 
`branch_name` varchar(50) NOT NULL, 
`status` varchar(10) NOT NULL, 
`chargeable` varchar(10) NOT NULL, 
`base_price` decimal(10,3) NOT NULL, 
`base_discount` int(10) NOT NULL, 
`part_share` decimal(10,3) DEFAULT NULL, 
`field_1` int(50) DEFAULT NULL, 
`field_2` int(50) DEFAULT NULL, 
`field_3` int(50) DEFAULT NULL, 
`field_4` int(50) DEFAULT NULL, 
`field_5` int(50) DEFAULT NULL, 
`start_date` date NOT NULL, 
`end_date` date NOT NULL, 
`feat_avail` varchar(50) DEFAULT NULL, 
`branch_owner` varchar(50) NOT NULL, 
`comment` varchar(500) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_branch_images` ( 
`branch_id` varchar(50) NOT NULL, 
`branch_name` varchar(50) NOT NULL, 
`branch_owner` varchar(50) NOT NULL, 
`img1` varchar(200) NOT NULL, 
`img2` varchar(200) DEFAULT NULL, 
`img3` varchar(200) DEFAULT NULL, 
`img4` varchar(200) DEFAULT NULL, 
`img5` varchar(200) DEFAULT NULL, 
`field_1` varchar(50) DEFAULT NULL, 
`start_date` date DEFAULT NULL, 
`end_date` date DEFAULT NULL, 
`comment` text, 
`img6` varchar(200) NOT NULL, 
`img7` varchar(200) NOT NULL, 
`img8` varchar(200) NOT NULL, 
`img9` varchar(200) NOT NULL, 
`img10` varchar(200) NOT NULL, 
`Location` varchar(300) NOT NULL, 
PRIMARY KEY (`branch_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_branch_master_details` ( 
`BranchCode` int(40) NOT NULL AUTO_INCREMENT, 
`BranchName` varchar(45) DEFAULT NULL, 
`BranchOwner` varchar(45) DEFAULT NULL, 
`Description` varchar(500) DEFAULT NULL, 
`specialization` varchar(200) DEFAULT NULL, 
`StartDate` varchar(45) DEFAULT NULL, 
`contactno` varchar(45) DEFAULT NULL, 
`emailid` varchar(45) DEFAULT NULL, 
`panno` varchar(45) DEFAULT NULL, 
`address` varchar(200) DEFAULT NULL, 
`city` varchar(45) DEFAULT NULL, 
`City_Name` varchar(100) DEFAULT NULL, 
`state` varchar(45) DEFAULT NULL, 
`country` varchar(45) DEFAULT NULL, 
`zipcode` varchar(45) DEFAULT NULL, 
`status` varchar(45) DEFAULT NULL, 
`managername` varchar(45) DEFAULT NULL, 
`manager_email` varchar(45) DEFAULT NULL, 
`manager_mobile` varchar(45) DEFAULT NULL, 
`land_line` varchar(45) DEFAULT NULL, 
`location` varchar(100) DEFAULT NULL, 
`house_rule` varchar(500) DEFAULT NULL, 
`terms_conditions` varchar(100) DEFAULT NULL, 
`can_policy` varchar(100) DEFAULT NULL, 
`latitude` varchar(200) DEFAULT NULL, 
`longitude` varchar(200) DEFAULT NULL, 
`term_file` varchar(100) DEFAULT NULL, 
`cancel_file` varchar(100) DEFAULT NULL, 
`location_id` varchar(50) DEFAULT NULL, 
`Work_Monday` varchar(30) DEFAULT 'Yes', 
`Work_Tuesday` varchar(30) DEFAULT 'Yes', 
`Work_Wednesday` varchar(30) DEFAULT 'Yes', 
`Work_Thursday` varchar(30) DEFAULT 'Yes', 
`Work_Friday` varchar(30) DEFAULT 'Yes', 
`Work_Saturday` varchar(30) DEFAULT 'Yes', 
`Work_Sunday` varchar(30) DEFAULT 'Yes', 
`book_thru_enquiry` varchar(10) NOT NULL DEFAULT 'Yes', 
`rating` int(10) DEFAULT '50', 
`verify` varchar(20) NOT NULL DEFAULT 'No', 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
`license_key` varchar(100) DEFAULT NULL, 
PRIMARY KEY (`BranchCode`) 
) 


CREATE TABLE IF NOT EXISTS `tx_business_enquiry_details` ( 
`enquiry_id` int(10) NOT NULL AUTO_INCREMENT, 
`Venue_Manager_Name` varchar(200) NOT NULL, 
`Property_Name` varchar(255) NOT NULL, 
`Mobile_No` varchar(15) NOT NULL, 
`Alt_Mobile_No` varchar(15) NOT NULL, 
`email` varchar(200) NOT NULL, 
`Address` varchar(500) NOT NULL, 
`Addtional_Notes` varchar(500) NOT NULL, 
PRIMARY KEY (`enquiry_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_campaign_details` ( 
`detail_id` int(30) NOT NULL AUTO_INCREMENT, 
`campaign_id` int(30) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`enable_rule` varchar(30) DEFAULT NULL, 
`applicable_type` varchar(30) DEFAULT NULL, 
`applicable_to` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`detail_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_campaign_email_queue` ( 
`ID` int(11) NOT NULL AUTO_INCREMENT, 
`reg_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`stud_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`receipt_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`email_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`subject` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`message_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`message_text` mediumtext CHARACTER SET utf8, 
`status` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`email_status` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`date_created` datetime DEFAULT NULL, 
`date_send` datetime DEFAULT NULL, 
`response` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`amount` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`user_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_1` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_2` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_3` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_4` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_5` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`due_date` datetime NOT NULL, 
`email_seq_id` int(11) NOT NULL DEFAULT '0', 
`img_src` varchar(200) DEFAULT NULL, 
`href_link` varchar(200) DEFAULT NULL, 
`audience` varchar(50) DEFAULT NULL, 
UNIQUE KEY `ID` (`ID`) 
) 


CREATE TABLE IF NOT EXISTS `tx_campaign_master` ( 
`campaign_id` int(30) NOT NULL AUTO_INCREMENT, 
`campaign_code` varchar(100) DEFAULT NULL, 
`campaign_name` varchar(100) DEFAULT NULL, 
`branch_id` varchar(100) DEFAULT NULL, 
`campaign_category` varchar(100) DEFAULT NULL, 
`created_date` varchar(100) DEFAULT NULL, 
`last_update_date` varchar(100) DEFAULT NULL, 
`limit_value` int(100) DEFAULT NULL, 
`effective_start_date` varchar(100) DEFAULT NULL, 
`effective_end_date` varchar(100) DEFAULT NULL, 
`message_id` varchar(100) DEFAULT NULL, 
`message_code` varchar(100) DEFAULT NULL, 
`applicable_to_all` varchar(100) DEFAULT NULL, 
`approval_status` varchar(100) DEFAULT NULL, 
`status` varchar(100) DEFAULT NULL, 
`img_attach` varchar(240) DEFAULT NULL, 
`email_body` varchar(1000) DEFAULT NULL, 
`href_link` varchar(200) DEFAULT NULL, 
`audience` varchar(50) DEFAULT 'Customers', 
`partner_id` varchar(50) DEFAULT 'PREG-00-0000-000', 
PRIMARY KEY (`campaign_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_campaign_message_queue` ( 
`ID` int(11) NOT NULL AUTO_INCREMENT, 
`reg_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`stud_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`receipt_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`mobile_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`email_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`message_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`message_text` varchar(500) CHARACTER SET utf8 DEFAULT NULL, 
`status` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`email_status` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`date_created` datetime DEFAULT NULL, 
`date_send` datetime DEFAULT NULL, 
`response` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`amount` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`user_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_1` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_2` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_3` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_4` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`field_5` varchar(255) CHARACTER SET utf8 DEFAULT NULL, 
`due_date` datetime DEFAULT NULL, 
`SMS_ID` int(11) NOT NULL DEFAULT '0', 
`audience` varchar(50) DEFAULT NULL, 
UNIQUE KEY `ID` (`ID`) 
) 


CREATE TABLE IF NOT EXISTS `tx_campaign_rules` ( 
`rule_id` int(30) NOT NULL AUTO_INCREMENT, 
`campaign_detail_id` int(30) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`rule_type` varchar(30) DEFAULT NULL, 
`reference_id` varchar(60) DEFAULT NULL, 
`reference_name` varchar(120) DEFAULT NULL, 
PRIMARY KEY (`rule_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_campaign_run_details` ( 
`campaign_run_id` int(30) NOT NULL AUTO_INCREMENT, 
`partner_id` varchar(30) DEFAULT NULL, 
`campaign_id` varchar(30) DEFAULT NULL, 
`campaign_file_name` varchar(150) DEFAULT NULL, 
`profile_id` varchar(30) DEFAULT NULL, 
`launch_date` varchar(60) DEFAULT NULL, 
PRIMARY KEY (`campaign_run_id`) 
) 

 
CREATE TABLE IF NOT EXISTS `cy_category_master` ( 
`ID` int(11) DEFAULT NULL, 
`category` varchar(255) DEFAULT NULL 
) 


CREATE TABLE IF NOT EXISTS `cy_city` ( 
`id` int(11) NOT NULL AUTO_INCREMENT, 
`State` varchar(255) DEFAULT NULL, 
`Country` varchar(255) DEFAULT NULL, 
`City` varchar(255) DEFAULT NULL, 
`Status` varchar(30) DEFAULT 'Active', 
UNIQUE KEY `zipcode_UNIQUE` (`id`), 
UNIQUE KEY `State` (`State`,`City`) 
) 


CREATE TABLE IF NOT EXISTS `tx_email_message_queue` ( 
`ID` int(11) DEFAULT NULL, 
`reg_id` varchar(255) DEFAULT NULL, 
`stud_name` varchar(255) DEFAULT NULL, 
`receipt_id` varchar(255) DEFAULT NULL, 
`email_id` varchar(255) DEFAULT NULL, 
`subject` varchar(255) DEFAULT NULL, 
`message_type` varchar(255) DEFAULT NULL, 
`message_text` mediumtext, 
`status` varchar(255) DEFAULT NULL, 
`email_status` varchar(255) DEFAULT NULL, 
`date_created` datetime DEFAULT NULL, 
`date_send` datetime DEFAULT NULL, 
`response` varchar(255) DEFAULT NULL, 
`amount` varchar(255) DEFAULT NULL, 
`user_name` varchar(255) DEFAULT NULL, 
`field_1` varchar(255) DEFAULT NULL, 
`field_2` varchar(255) DEFAULT NULL, 
`field_3` varchar(255) DEFAULT NULL, 
`field_4` varchar(255) DEFAULT NULL, 
`field_5` varchar(255) DEFAULT NULL, 
`due_date` varchar(100) NOT NULL, 
`email_seq_id` int(11) NOT NULL AUTO_INCREMENT, 
PRIMARY KEY (`email_seq_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_facility_master` ( 
`fac_id` varchar(50) NOT NULL, 
`fac_name` varchar(100) NOT NULL, 
`fac_type` varchar(50) NOT NULL, 
`fac_size` varchar(50) DEFAULT NULL, 
`fac_capcity` varchar(50) DEFAULT NULL, 
`fac_comment` varchar(500) DEFAULT NULL, 
`fac_shared` varchar(50) DEFAULT NULL, 
`base_price` decimal(10,3) DEFAULT NULL, 
`base_discount` decimal(10,3) DEFAULT NULL, 
`base_share` decimal(10,3) DEFAULT NULL, 
`field_1` varchar(50) DEFAULT NULL, 
`field_2` varchar(50) DEFAULT NULL, 
`field_3` varchar(50) DEFAULT NULL, 
`field_4` varchar(50) DEFAULT NULL, 
`field_5` varchar(50) DEFAULT NULL, 
`field_6` varchar(50) DEFAULT NULL, 
`field_7` varchar(50) DEFAULT NULL, 
`Branch_id` varchar(50) DEFAULT NULL, 
`branch_name` varchar(100) NOT NULL, 
`start_date` date NOT NULL, 
`end_date` date NOT NULL, 
`branch_owner` varchar(100) NOT NULL, 
`fac_avail` varchar(50) DEFAULT NULL, 
`floor` varchar(50) NOT NULL, 
`floor_id` varchar(10) DEFAULT NULL, 
`fac_gran` varchar(50) DEFAULT NULL, 
`partner_id` varchar(100) DEFAULT NULL, 
`fac_layout_id` varchar(30) DEFAULT NULL, 
`fac_layout_name` varchar(50) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_facility_price` ( 
`branch_id` varchar(50) NOT NULL, 
`branch_name` varchar(50) NOT NULL, 
`facility_id` varchar(50) NOT NULL, 
`facility_name` varchar(50) NOT NULL, 
`tariff_id` varchar(50) DEFAULT NULL, 
`category` varchar(50) NOT NULL, 
`base_price` int(11) DEFAULT NULL, 
`discount` int(50) DEFAULT NULL, 
`partner_share` int(50) DEFAULT NULL, 
`display` varchar(10) DEFAULT NULL, 
`commnet` varchar(200) DEFAULT NULL, 
`field_1` varchar(100) DEFAULT NULL, 
`field_2` varchar(100) DEFAULT NULL, 
`field_3` varchar(100) DEFAULT NULL, 
`partner_name` varchar(100) NOT NULL, 
`start_date` datetime NOT NULL, 
`end_date` date NOT NULL, 
`search_display` varchar(10) DEFAULT NULL, 
`standard_price` varchar(10) DEFAULT NULL, 
`corporate_price` varchar(10) DEFAULT NULL, 
`standard_disc` varchar(10) DEFAULT NULL, 
`corporate_disc` varchar(10) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_feature_master` ( 
`feature_id` varchar(50) NOT NULL, 
`feature_name` varchar(50) NOT NULL, 
`fac_id` varchar(50) NOT NULL, 
`fac_name` varchar(50) NOT NULL, 
`status` varchar(10) NOT NULL, 
`chargeable` varchar(10) NOT NULL, 
`base_price` decimal(10,3) NOT NULL, 
`base_discount` int(10) NOT NULL, 
`part_share` decimal(10,3) DEFAULT NULL, 
`field_1` int(50) DEFAULT NULL, 
`field_2` int(50) DEFAULT NULL, 
`field_3` int(50) DEFAULT NULL, 
`field_4` int(50) DEFAULT NULL, 
`field_5` int(50) DEFAULT NULL, 
`start_date` date NOT NULL, 
`end_date` date NOT NULL, 
`feat_avail` varchar(50) DEFAULT NULL, 
`partner_id` varchar(100) DEFAULT NULL, 
`branch_id` varchar(50) DEFAULT NULL, 
`branch_name` varchar(100) DEFAULT NULL, 
`comment` varchar(500) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_floor_layout_details` ( 
`seat_id` int(10) NOT NULL AUTO_INCREMENT, 
`layout_id` varchar(50) NOT NULL, 
`branch_id` int(6) NOT NULL, 
`position_id` int(6) NOT NULL, 
`seat_type` varchar(6) NOT NULL, 
`child_layout_id` varchar(50) NOT NULL, 
`Item_id` int(6) NOT NULL, 
`floor_id` varchar(20) NOT NULL, 
`floor` varchar(50) NOT NULL DEFAULT 'Ground Floor', 
`fac_id` varchar(60) NOT NULL, 
`Status` varchar(10) NOT NULL DEFAULT 'Active', 
`Seat_selection` varchar(1) NOT NULL DEFAULT 'A', 
PRIMARY KEY (`seat_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_floor_layout_master` ( 
`layout_id` varchar(50) NOT NULL, 
`layout_name` varchar(50) NOT NULL, 
`layout_status` varchar(20) NOT NULL DEFAULT 'Active', 
`start_date` date NOT NULL, 
`branch_id` int(6) NOT NULL, 
`floor_id` varchar(20) NOT NULL, 
`floor` varchar(50) NOT NULL DEFAULT 'Ground Floor', 
`fac_id` varchar(10) DEFAULT NULL, 
PRIMARY KEY (`layout_id`), 
UNIQUE KEY `layout_id` (`layout_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_forget_password` ( 
`email` varchar(200) NOT NULL, 
`phone` varchar(200) NOT NULL, 
`token_no` varchar(200) NOT NULL, 
`time` date NOT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_general_contact_us` ( 
`name` varchar(60) NOT NULL, 
`emailid` varchar(100) NOT NULL, 
`contactno` varchar(14) NOT NULL, 
`subject` varchar(200) NOT NULL, 
`message` varchar(500) NOT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_holiday_master` ( 
`holiday_id` int(30) NOT NULL AUTO_INCREMENT, 
`holiday_date` date DEFAULT NULL, 
`holiday_type` varchar(60) DEFAULT 'Public Holiday', 
`status` varchar(30) DEFAULT 'Active', 
`Partner_Id` varchar(30) DEFAULT NULL, 
`Branch_Id` varchar(20) DEFAULT NULL, 
PRIMARY KEY (`holiday_id`), 
UNIQUE KEY `holiday_date` (`holiday_date`) 
) 


CREATE TABLE IF NOT EXISTS `cy_inst_mat` ( 
`Inst_id` varchar(255) DEFAULT NULL, 
`Inst_name` varchar(255) DEFAULT NULL, 
`field_1` varchar(255) DEFAULT NULL, 
`field_2` varchar(255) DEFAULT NULL, 
`field_3` varchar(255) DEFAULT NULL, 
`field_4` varchar(255) DEFAULT NULL, 
`field_5` varchar(255) DEFAULT NULL 
) table not required but data is needed map to lookup master 


CREATE TABLE IF NOT EXISTS `tx_interactions` ( 
`interaction_id` int(10) NOT NULL AUTO_INCREMENT, 
`Interaction_No` varchar(100) NOT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`cust_profile_id` varchar(10) DEFAULT NULL, 
`category` varchar(30) DEFAULT NULL, 
`followup` varchar(30) NOT NULL DEFAULT 'No', 
`agent_id` varchar(30) DEFAULT NULL, 
`message_details` varchar(400) DEFAULT NULL, 
`due_date` varchar(20) DEFAULT NULL, 
`comments` varchar(250) DEFAULT NULL, 
`created_date` varchar(20) DEFAULT NULL, 
`last_update_date` varchar(20) DEFAULT NULL, 
`customer_name` varchar(200) DEFAULT NULL, 
`branch_owner` varchar(200) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`interaction_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_item_master` ( 
`item_id` int(6) NOT NULL AUTO_INCREMENT, 
`item_number` varchar(30) NOT NULL, 
`description` varchar(100) NOT NULL, 
`asset_id` int(6) NOT NULL, 
`branch_id` int(6) NOT NULL, 
PRIMARY KEY (`item_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_layout_master` ( 
`layout_id` int(10) NOT NULL AUTO_INCREMENT, 
`layout_name` varchar(30) DEFAULT 'Layout', 
`primary_layout` varchar(6) DEFAULT 'No', 
`branch_id` varchar(30) NOT NULL, 
`layout_map` varchar(50) DEFAULT NULL, 
`floor_id` varchar(20) DEFAULT NULL, 
`floor` varchar(50) DEFAULT NULL, 
`date` varchar(10) DEFAULT NULL, 
`status` varchar(10) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
UNIQUE KEY `layout_id` (`layout_id`), 
UNIQUE KEY `branch_id` (`branch_id`,`floor_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_license_branch_details` ( 
`detail_id` int(50) NOT NULL AUTO_INCREMENT, 
`license_id` int(50) DEFAULT NULL, 
`branch_id` varchar(50) DEFAULT NULL, 
`applied_date` varchar(50) DEFAULT NULL, 
`valid_from` varchar(50) DEFAULT NULL, 
`valid_to` varchar(50) DEFAULT NULL, 
`created_by` varchar(100) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
`license_key` varchar(100) DEFAULT NULL, 
PRIMARY KEY (`detail_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_license_details` ( 
`license_id` int(50) NOT NULL AUTO_INCREMENT, 
`license_key` varchar(50) DEFAULT NULL, 
`license_name` varchar(50) DEFAULT NULL, 
`license_type` varchar(50) DEFAULT 'Yearly', 
`user_type` varchar(50) DEFAULT 'Branch', 
`users_allowed` int(50) DEFAULT '0', 
`users_consumed` int(50) DEFAULT '0', 
`valid_from` varchar(50) DEFAULT NULL, 
`valid_to` varchar(50) DEFAULT NULL, 
`status` varchar(50) DEFAULT 'Active', 
`license_price_id` varchar(50) DEFAULT NULL, 
`partner_id` varchar(50) DEFAULT NULL, 
`auto_renewal` varchar(50) DEFAULT 'No', 
`renewed_date` varchar(50) DEFAULT NULL, 
`renewed_license_id` varchar(50) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(100) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(100) DEFAULT NULL, 
PRIMARY KEY (`license_id`), 
UNIQUE KEY `license_key` (`license_key`,`partner_id`) 
) 


CREATE TABLE IF NOT EXISTS `cy_license_page_access` ( 
`access_id` int(50) NOT NULL AUTO_INCREMENT, 
`page_id` int(50) DEFAULT NULL, 
`license_name` varchar(50) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`status` varchar(50) NOT NULL DEFAULT 'Active', 
PRIMARY KEY (`access_id`) 
) 


CREATE TABLE IF NOT EXISTS `cy_license_page_details` ( 
`page_id` int(50) NOT NULL AUTO_INCREMENT, 
`page_number` varchar(50) DEFAULT NULL, 
`page_name` varchar(50) DEFAULT NULL, 
`page_file_name` varchar(50) DEFAULT NULL, 
`status` varchar(50) DEFAULT 'Active', 
PRIMARY KEY (`page_id`), 
UNIQUE KEY `page_file_name` (`page_file_name`), 
UNIQUE KEY `page_number` (`page_number`) 
) 


CREATE TABLE IF NOT EXISTS `cy_license_price` ( 
`price_id` int(50) NOT NULL AUTO_INCREMENT, 
`license_name` varchar(50) DEFAULT NULL, 
`license_type` varchar(50) DEFAULT 'Yearly', 
`currency` varchar(50) DEFAULT 'INR', 
`price` varchar(50) DEFAULT NULL, 
`billing_frequency` varchar(50) DEFAULT 'Monthly', 
`valid_from` varchar(50) DEFAULT NULL, 
`valid_to` varchar(50) DEFAULT NULL, 
`status` varchar(50) DEFAULT 'Active', 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`price_id`) 
) 


CREATE TABLE IF NOT EXISTS `cy_location` ( 
`location_id` int(6) NOT NULL AUTO_INCREMENT, 
`city_id` int(6) NOT NULL, 
`location_name` varchar(100) NOT NULL, 
`latitude` float(15,11) NOT NULL, 
`longitude` float(15,11) NOT NULL, 
`zipcode` varchar(6) NOT NULL, 
`Status` varchar(30) DEFAULT 'Active', 
PRIMARY KEY (`location_id`), 
UNIQUE KEY `city_id` (`city_id`,`location_name`) 
) 




CREATE TABLE IF NOT EXISTS `tx_login` ( 
`User_id` varchar(255) DEFAULT NULL, 
`User_password` varchar(255) DEFAULT NULL, 
`User_profile` varchar(255) DEFAULT NULL, 
`user_name` varchar(255) DEFAULT NULL, 
`start_date` datetime DEFAULT NULL, 
`end_date` datetime DEFAULT NULL, 
`expiry_days` int(11) DEFAULT NULL, 
`app_type` varchar(255) DEFAULT NULL, 
`last_modified` datetime DEFAULT NULL, 
`General_1` varchar(255) DEFAULT NULL, 
`General_2` varchar(255) DEFAULT NULL, 
`General_3` varchar(255) DEFAULT NULL, 
`General_4` varchar(255) DEFAULT NULL, 
`General_5` varchar(255) DEFAULT NULL, 
`user_type` varchar(45) DEFAULT NULL, 
`dealer_code` varchar(45) DEFAULT NULL, 
`reg_id` varchar(30) DEFAULT NULL, 
UNIQUE KEY `User_id` (`User_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_login_attempts` ( 
`IP` varchar(50) NOT NULL, 
`Attempts` int(11) NOT NULL, 
`LastLogin` datetime NOT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_login_audit` ( 
`ID` int(11) DEFAULT NULL, 
`user_name` varchar(255) DEFAULT NULL, 
`login_date_time` datetime DEFAULT NULL, 
`app_type` varchar(255) DEFAULT NULL, 
`machine_name` varchar(255) DEFAULT NULL, 
`location` varchar(255) DEFAULT NULL, 
`IP_addrss` varchar(255) DEFAULT NULL, 
`Field_1` varchar(255) DEFAULT NULL, 
`Field_2` varchar(255) DEFAULT NULL, 
`Field_3` varchar(255) DEFAULT NULL, 
`Field_4` varchar(255) DEFAULT NULL, 
`Field_5` varchar(255) DEFAULT NULL, 
`Field_6` varchar(255) DEFAULT NULL 
) 


CREATE TABLE IF NOT EXISTS `cy_lookup_master` ( 
`lookup_id` int(6) NOT NULL AUTO_INCREMENT, 
`lookup_type` varchar(200) DEFAULT NULL, 
`lookup_code` varchar(200) DEFAULT NULL, 
`lookup_values` varchar(200) DEFAULT NULL, 
`Attribute1` blob NOT NULL, 
`icon` varchar(150) DEFAULT NULL, 
`icon_images` varchar(200) DEFAULT NULL, 
`parent_id` varchar(50) DEFAULT NULL, 
`attribute2` varchar(100) DEFAULT NULL, 
PRIMARY KEY (`lookup_id`), 
UNIQUE KEY `lookup_type` (`lookup_type`,`lookup_code`,`lookup_values`) 
) 




CREATE TABLE IF NOT EXISTS `tx_message_queue` ( 
`ID` int(11) DEFAULT NULL, 
`reg_id` varchar(255) DEFAULT NULL, 
`stud_name` varchar(255) DEFAULT NULL, 
`receipt_id` varchar(255) DEFAULT NULL, 
`mobile_no` varchar(255) DEFAULT NULL, 
`email_id` varchar(255) DEFAULT NULL, 
`message_type` varchar(255) DEFAULT NULL, 
`message_text` varchar(500) DEFAULT NULL, 
`status` varchar(255) DEFAULT NULL, 
`email_status` varchar(255) DEFAULT NULL, 
`date_created` datetime DEFAULT NULL, 
`date_send` datetime DEFAULT NULL, 
`response` varchar(255) DEFAULT NULL, 
`amount` varchar(255) DEFAULT NULL, 
`user_name` varchar(255) DEFAULT NULL, 
`field_1` varchar(255) DEFAULT NULL, 
`field_2` varchar(255) DEFAULT NULL, 
`field_3` varchar(255) DEFAULT NULL, 
`field_4` varchar(255) DEFAULT NULL, 
`field_5` varchar(255) DEFAULT NULL, 
`due_date` datetime DEFAULT NULL, 
`SMS_ID` int(11) NOT NULL AUTO_INCREMENT, 
PRIMARY KEY (`SMS_ID`) 
) 


CREATE TABLE IF NOT EXISTS `tx_message_text` ( 
`ID` int(11) NOT NULL DEFAULT '0', 
`msg_id` varchar(255) DEFAULT NULL, 
`msg_name` varchar(255) DEFAULT NULL, 
`msg_type` varchar(255) DEFAULT NULL, 
`msg_text` mediumtext, 
`msg_media` varchar(255) DEFAULT NULL, 
`field_1` varchar(255) DEFAULT NULL, 
`field_2` varchar(255) DEFAULT NULL, 
`field_3` varchar(255) DEFAULT NULL, 
`field_4` varchar(255) DEFAULT NULL, 
`field_5` varchar(255) DEFAULT NULL, 
PRIMARY KEY (`ID`) 
) 

 
CREATE TABLE IF NOT EXISTS `cy_meter_details` ( 
`meter_id` int(30) NOT NULL AUTO_INCREMENT, 
`partner_id` varchar(50) NOT NULL, 
`entity_name` varchar(100) NOT NULL, 
`limit_value` int(20) NOT NULL DEFAULT '0', 
`consumed_value` int(20) DEFAULT '0', 
`valid_from` varchar(50) DEFAULT NULL, 
`valid_to` varchar(50) DEFAULT NULL, 
`status` varchar(50) DEFAULT 'Active', 
PRIMARY KEY (`meter_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_otp_validation` ( 
`validation_id` int(200) NOT NULL AUTO_INCREMENT, 
`mobile_no` varchar(200) DEFAULT NULL, 
`otp_id` varchar(200) DEFAULT NULL, 
`valid_from` varchar(200) DEFAULT NULL, 
`valid_to` varchar(200) DEFAULT NULL, 
`first_name` varchar(200) DEFAULT NULL, 
`last_name` varchar(200) DEFAULT NULL, 
`email_id` varchar(200) DEFAULT NULL, 
PRIMARY KEY (`validation_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_package_details` ( 
`detail_id` int(10) NOT NULL AUTO_INCREMENT, 
`package_id` int(10) NOT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`category` varchar(30) DEFAULT NULL, 
`status` varchar(30) NOT NULL DEFAULT 'Active', 
`facility_type` varchar(60) DEFAULT NULL, 
`fac_id` varchar(60) DEFAULT NULL, 
`package_limit` varchar(30) DEFAULT NULL, 
`UOM` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`detail_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_package_master` ( 
`package_id` int(10) NOT NULL AUTO_INCREMENT, 
`branch_id` varchar(10) DEFAULT NULL, 
`package_code` varchar(30) DEFAULT NULL, 
`package_name` varchar(100) DEFAULT NULL, 
`valid_from` varchar(100) DEFAULT NULL, 
`valid_to` varchar(100) DEFAULT NULL, 
`package_amount` varchar(50) DEFAULT NULL, 
`status` varchar(30) DEFAULT NULL, 
`approval_status` varchar(30) DEFAULT NULL, 
`created_date` varchar(30) DEFAULT NULL, 
`update_date` varchar(30) DEFAULT NULL, 
`used_value` int(10) DEFAULT NULL, 
PRIMARY KEY (`package_id`) 
) 


CREATE TABLE IF NOT EXISTS `vendor_profile` ( 
`Part_Id` varchar(20) NOT NULL, 
`Part_F_name` varchar(50) NOT NULL, 
`Part_M_Nae` varchar(50) DEFAULT NULL, 
`Part_Surname` varchar(50) NOT NULL, 
`ID_No` varchar(20) NOT NULL, 
`PAN` varchar(20) DEFAULT NULL, 
`DOB` varchar(20) DEFAULT NULL, 
`addr` varchar(200) DEFAULT NULL, 
`add_1` varchar(200) NOT NULL, 
`city` varchar(30) NOT NULL, 
`state` varchar(30) NOT NULL, 
`country` varchar(30) NOT NULL, 
`p_contact` varchar(15) NOT NULL, 
`s_contact` varchar(15) DEFAULT NULL, 
`email` varchar(180) NOT NULL, 
`status` varchar(10) NOT NULL DEFAULT 'Active', 
`total_due` decimal(5,0) DEFAULT NULL, 
`type` varchar(10) NOT NULL, 
`active_date` date DEFAULT NULL, 
`end_date` date DEFAULT NULL, 
`unique_id` varchar(30) NOT NULL, 
`user_id` varchar(30) NOT NULL, 
`last_modified` date DEFAULT NULL, 
`Allow_campaign` varchar(10) DEFAULT 'Yes', 
`other` varchar(20) DEFAULT NULL, 
`campaign_contact_type` varchar(30) DEFAULT 'Private', 
`partner_logo` varchar(100) DEFAULT NULL, 
`Publish_contact` varchar(10) DEFAULT 'Yes', 
`Partner_Services` varchar(30) DEFAULT 'No', 
`currency` varchar(30) DEFAULT 'INR', 
`brand_name` varchar(50) NOT NULL, 
`comp_name` varchar(50) NOT NULL, 
`comp_reg_id` varchar(50) DEFAULT NULL, 
`service` varchar(50) NOT NULL DEFAULT 'ALL', 
`comp_type` varchar(50) DEFAULT NULL, 
`zip_code` varchar(10) NOT NULL, 
`bank_name` varchar(100) DEFAULT NULL, 
`Bank_code` varchar(100) DEFAULT NULL, 
`bank_field_1` varchar(100) DEFAULT NULL, 
`bank_field_2` varchar(100) DEFAULT NULL, 
`bank_field_3` varchar(100) DEFAULT NULL, 
`floor` varchar(50) DEFAULT NULL, 
`tax_code_id` varchar(10) DEFAULT '1', 
`payment_term_id` varchar(10) DEFAULT NULL, 
`allow_selection` varchar(10) NOT NULL DEFAULT 'Yes', 
`Advance_Type` varchar(30) NOT NULL DEFAULT 'Percent', 
`Advance_Value` varchar(30) DEFAULT NULL, 
`Pay_Adv_Term_ID` varchar(30) DEFAULT '0', 
`location` varchar(40) DEFAULT NULL, 
`category` varchar(20) DEFAULT NULL, 
`License_Pack` varchar(50) NOT NULL DEFAULT 'Listing Only', 
`club` varchar(50) DEFAULT 'Standard', 
`trial_tried` varchar(50) DEFAULT 'No', 
`trial_start_date` varchar(50) DEFAULT NULL, 
`trial_end_date` varchar(50) DEFAULT NULL, 
`url` varchar(100) DEFAULT NULL, 
`latitude` varchar(100) DEFAULT NULL, 
`longitude` varchar(100) DEFAULT NULL, 
PRIMARY KEY (`Part_Id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_partner_enquiry_master` ( 
`firstname` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL, 
`lastname` varchar(50) NOT NULL, 
`company` varchar(50) NOT NULL, 
`email` varchar(50) NOT NULL, 
`phno` varchar(50) NOT NULL, 
`address` varchar(100) NOT NULL, 
`location` varchar(300) NOT NULL, 
`country` varchar(50) NOT NULL, 
`state` varchar(50) NOT NULL, 
`city` varchar(50) NOT NULL, 
`zip` varchar(10) NOT NULL, 
`Description` varchar(600) NOT NULL 
) 


CREATE TABLE IF NOT EXISTS `tx_partner_pay_share` ( 
`Partner_id` varchar(30) NOT NULL, 
`Per_amt` int(3) DEFAULT NULL, 
`Partner_tax_per` int(3) DEFAULT NULL, 
`start_date` datetime NOT NULL, 
`end_date` datetime NOT NULL, 
`comment` varchar(100) DEFAULT NULL, 
`field_1` varchar(50) DEFAULT NULL, 
`field_2` varchar(50) DEFAULT NULL, 
`pay_share_based_on` varchar(50) NOT NULL, 
`fix_amt` int(10) NOT NULL, 
`Partner_name` varchar(50) NOT NULL, 
`reg_id` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`Partner_id`), 
UNIQUE KEY `Partner_id` (`Partner_id`) 
) 



CREATE TABLE IF NOT EXISTS `tx_payment_terms` ( 
`payment_term_id` int(6) NOT NULL AUTO_INCREMENT, 
`payment_term_name` varchar(100) NOT NULL, 
`net_days` int(6) NOT NULL, 
`status` varchar(30) NOT NULL DEFAULT 'Active', 
PRIMARY KEY (`payment_term_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_popular_cities` ( 
`popular_id` int(50) NOT NULL AUTO_INCREMENT, 
`city_id` varchar(50) DEFAULT NULL, 
`city_name` varchar(100) DEFAULT NULL, 
`latitude` varchar(100) DEFAULT NULL, 
`longitude` varchar(100) DEFAULT NULL, 
`img` varchar(200) DEFAULT NULL, 
`branch_count` int(100) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`location_name` varchar(500) NOT NULL, 
PRIMARY KEY (`popular_id`) 
) 



CREATE TABLE IF NOT EXISTS `tx_profile_master` ( 
`profile_id` int(10) NOT NULL AUTO_INCREMENT, 
`profile_number` varchar(30) DEFAULT NULL, 
`profile_type` varchar(30) DEFAULT 'Individual', 
`branch_id` varchar(6) DEFAULT NULL, 
`first_name` varchar(50) DEFAULT NULL, 
`last_name` varchar(50) DEFAULT NULL, 
`cust_company_name` varchar(200) DEFAULT NULL, 
`cust_company_name_other` varchar(20) DEFAULT NULL, 
`dob` varchar(100) DEFAULT NULL, 
`know_us_source` varchar(50) DEFAULT NULL, 
`know_us_source_Other` varchar(200) DEFAULT NULL, 
`company_profile_id` int(10) DEFAULT NULL, 
`company_name` varchar(50) DEFAULT NULL, 
`company_contact_name` varchar(50) DEFAULT NULL, 
`contact_mobile_no` varchar(50) DEFAULT NULL, 
`contact_email_id` varchar(100) DEFAULT NULL, 
`contact_alt_phone` varchar(30) DEFAULT NULL, 
`contact_alt_email` varchar(50) DEFAULT NULL, 
`relationship` varchar(100) DEFAULT NULL, 
`partner_id` varchar(100) DEFAULT NULL, 
`Country` varchar(100) DEFAULT NULL, 
`State` varchar(100) DEFAULT NULL, 
`City` varchar(50) DEFAULT NULL, 
`Address` varchar(100) DEFAULT NULL, 
`Street` varchar(100) DEFAULT NULL, 
`Zipcode` varchar(50) DEFAULT NULL, 
`price_list` varchar(50) DEFAULT NULL, 
`discount_type` varchar(50) DEFAULT NULL, 
`flat_discount_percent` varchar(10) DEFAULT NULL, 
`gender` varchar(50) DEFAULT NULL, 
`profile_category` varchar(50) DEFAULT NULL, 
`Id_Type` varchar(50) DEFAULT NULL, 
`Id_number` varchar(50) DEFAULT NULL, 
`Id_name` varchar(100) DEFAULT NULL, 
`Alt_Id_Type` varchar(200) DEFAULT NULL, 
`C_Id_Name` varchar(200) DEFAULT NULL, 
`C_ID_Number` varchar(200) DEFAULT NULL, 
`membership` varchar(10) NOT NULL DEFAULT 'No', 
`email_msg_id` varchar(30) DEFAULT NULL, 
`sms_msg_id` varchar(30) DEFAULT NULL, 
`Booking_Enq_no` varchar(40) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_date` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
`location` varchar(50) DEFAULT NULL, 
`status` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`profile_id`), 
UNIQUE KEY `contact_email_id` (`contact_email_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_profile_wishlist` ( 
`list_id` int(30) NOT NULL AUTO_INCREMENT, 
`profile_id` varchar(30) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`status` varchar(30) DEFAULT NULL, 
`created_date` date DEFAULT NULL, 
`last_updated_date` date DEFAULT NULL, 
PRIMARY KEY (`list_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_promotion_details` ( 
`detail_id` int(10) NOT NULL AUTO_INCREMENT, 
`promo_id` int(10) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`enable_rule` varchar(30) DEFAULT NULL, 
`applicable_type` varchar(30) DEFAULT NULL, 
`applicable_to` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`detail_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_promotion_master` ( 
`promo_id` int(10) NOT NULL AUTO_INCREMENT, 
`promo_code` varchar(100) DEFAULT NULL, 
`promo_name` varchar(100) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`promo_type` varchar(30) DEFAULT NULL, 
`transaction_limit_type` varchar(30) DEFAULT NULL, 
`limit_value` int(30) DEFAULT NULL, 
`effective_start_date` varchar(10) DEFAULT NULL, 
`effective_end_date` varchar(10) DEFAULT NULL, 
`applicable_to_all` varchar(30) NOT NULL DEFAULT 'Yes', 
`approval_status` varchar(30) NOT NULL DEFAULT 'DRAFT', 
`status` varchar(30) DEFAULT NULL, 
`discount_type` varchar(30) DEFAULT 'Percent', 
`discount_value` int(30) DEFAULT '0', 
`used_value` varchar(30) DEFAULT NULL, 
`created_date` varchar(30) DEFAULT NULL, 
`last_update_date` varchar(30) DEFAULT NULL, 
`partner_id` varchar(50) DEFAULT 'PREG-00-0000-000', 
PRIMARY KEY (`promo_id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_promotion_rules` ( 
`rule_id` int(10) NOT NULL AUTO_INCREMENT, 
`promo_detail_id` varchar(10) DEFAULT NULL, 
`branch_id` varchar(30) DEFAULT NULL, 
`rule_type` varchar(30) DEFAULT NULL, 
`reference_id` varchar(60) DEFAULT NULL, 
`reference_name` varchar(100) DEFAULT NULL, 
PRIMARY KEY (`rule_id`) 
) 



CREATE TABLE IF NOT EXISTS `tx_receipt_master` ( 
`receipt_id` int(10) NOT NULL AUTO_INCREMENT, 
`branch_id` varchar(30) DEFAULT NULL, 
`booking_header_id` varchar(30) DEFAULT NULL, 
`receipt_date` date DEFAULT NULL, 
`receipt_amount` int(30) DEFAULT NULL, 
`receipt_currency` varchar(30) NOT NULL DEFAULT 'INR', 
`receipt_mode` varchar(100) DEFAULT NULL, 
`bank_name` varchar(100) DEFAULT NULL, 
`branch_name` varchar(100) DEFAULT NULL, 
`status` varchar(30) NOT NULL DEFAULT 'Open', 
`applied_amount` int(30) DEFAULT NULL, 
`remittance_date` date DEFAULT NULL, 
`remittance_amount` int(30) DEFAULT NULL, 
`transaction_type` varchar(30) NOT NULL DEFAULT 'Automatic', 
`cancel_reason` varchar(240) DEFAULT NULL, 
`Receipt_No` varchar(30) DEFAULT NULL, 
`cust_profile_no` varchar(50) DEFAULT NULL, 
`bill_ref_no` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`receipt_id`) 
) 



CREATE TABLE IF NOT EXISTS `tx_seat_availability_details` ( 
`Seat_Availability_Id` int(10) NOT NULL AUTO_INCREMENT, 
`branch_id` varchar(30) DEFAULT NULL, 
`Fac_Type` varchar(30) DEFAULT NULL, 
`Seat_Available` varchar(10) DEFAULT NULL, 
`last_update_date` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`Seat_Availability_Id`) 
) 


CREATE TABLE IF NOT EXISTS `tx_seq_id` ( 
`Seq_name` varchar(255) NOT NULL DEFAULT '', 
`Seq_Num` int(11) DEFAULT NULL, 
PRIMARY KEY (`Seq_name`) 
) 


CREATE TABLE IF NOT EXISTS `tx_server_admin` ( 
`server_type` varchar(255) NOT NULL DEFAULT '', 
`user_name` varchar(255) DEFAULT NULL, 
`password` varchar(255) DEFAULT NULL, 
`port` varchar(255) DEFAULT NULL, 
`proxy` varchar(255) DEFAULT NULL, 
`email_id` varchar(255) DEFAULT NULL, 
`ph_no` varchar(255) DEFAULT NULL, 
`smtp_host` varchar(255) DEFAULT NULL, 
`smtp_port` varchar(255) DEFAULT NULL, 
`smtp_auth` varchar(255) DEFAULT NULL, 
`host_email_id` varchar(255) DEFAULT NULL, 
`host_email_pa` varchar(255) DEFAULT NULL, 
`Field_1` varchar(255) DEFAULT NULL, 
`Field_2` varchar(255) DEFAULT NULL, 
`Field_3` varchar(255) DEFAULT NULL, 
`Field_4` varchar(255) DEFAULT NULL, 
`Field_5` varchar(255) DEFAULT NULL, 
PRIMARY KEY (`server_type`) 
) 


CREATE TABLE IF NOT EXISTS `tx_service_request` ( 
`request_id` int(10) NOT NULL AUTO_INCREMENT, 
`branch_id` varchar(50) DEFAULT NULL, 
`cust_profile_id` varchar(50) DEFAULT NULL, 
`Issue_name` varchar(100) DEFAULT NULL, 
`Issue_description` varchar(250) DEFAULT NULL, 
`priority` varchar(10) NOT NULL DEFAULT 'P2', 
`created_date` varchar(20) DEFAULT NULL, 
`last_update_date` varchar(20) DEFAULT NULL, 
`due_date` varchar(20) DEFAULT NULL, 
`status` varchar(50) DEFAULT NULL, 
`assigned_to` varchar(50) DEFAULT NULL, 
`comments` varchar(250) DEFAULT NULL, 
`resolution` varchar(250) DEFAULT NULL, 
`cust_feedback` varchar(250) DEFAULT NULL, 
`sr_no` varchar(30) NOT NULL, 
`created_by` varchar(50) DEFAULT NULL, 
`last_updated_by` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`request_id`) 
) 



 
CREATE TABLE IF NOT EXISTS `tx_suggestions` ( 
`Suggestion_ID` int(10) NOT NULL AUTO_INCREMENT, 
`email` varchar(50) DEFAULT NULL, 
`contact_no` varchar(50) DEFAULT NULL, 
`subject` varchar(70) DEFAULT NULL, 
`suggestion` varchar(300) DEFAULT NULL, 
`name` varchar(30) DEFAULT NULL, 
PRIMARY KEY (`Suggestion_ID`) 
) 


CREATE TABLE IF NOT EXISTS `tx_tax_master` ( 
`tax_code_id` int(6) NOT NULL AUTO_INCREMENT, 
`tax_code` varchar(30) NOT NULL, 
`tax_percent` int(3) NOT NULL, 
`status` varchar(30) NOT NULL DEFAULT 'Active', 
`start_date` date DEFAULT NULL, 
`end_date` date DEFAULT NULL, 
PRIMARY KEY (`tax_code_id`) 
) 

 
CREATE TABLE IF NOT EXISTS `tx_visit_audit` ( 
`audit_id` int(50) NOT NULL AUTO_INCREMENT, 
`audit_type` varchar(50) DEFAULT 'Branch', 
`visit_cntr` int(50) DEFAULT '0', 
`user_id` varchar(50) DEFAULT NULL, 
`mobile_no` varchar(50) DEFAULT NULL, 
`created_date` varchar(50) DEFAULT NULL, 
`updated_date` varchar(50) DEFAULT NULL, 
`branch_id` varchar(50) DEFAULT NULL, 
`session_id` varchar(50) DEFAULT NULL, 
PRIMARY KEY (`audit_id`) 
)


CREATE TABLE `tx_general_contact_us` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL ,
  `emailid` varchar(100) NOT NULL,
  `contactno` varchar(14) NOT NULL,
  `subject` varchar(200) NOT NULL,
  `message` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) 


CREATE TABLE `sosvedu_apna`.`cy_menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `menu_name` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `cy_product_category` ( 
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) DEFAULT NULL,
	`description` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`) 
) ;

CREATE TABLE IF NOT EXISTS `tx_vendor_product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`unique_id` varchar(20) NOT NULL,
	`name` varchar(255) DEFAULT NULL,
	`description` varchar(255) DEFAULT NULL,
	`product_category_id` INT,
	`image_id` INT,
	`Part_Id` varchar(255) DEFAULT NULL,
	PRIMARY KEY (`id`) 
);


CREATE TABLE IF NOT EXISTS `cy_vendor_lead` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT,	
	`name` varchar(255) DEFAULT NULL,
	`mobile_no` varchar(255) DEFAULT NULL,
	`email` varchar(255) DEFAULT NULL,
	`address` varchar(255) DEFAULT NULL,
	`vendor_id` varchar(255) DEFAULT NULL,
	`product_id` varchar(255) DEFAULT NULL,
	`visit_count` INT default 0,
	PRIMARY KEY (`id`) 
);

INSERT INTO `sosvedu_apna`.`cy_menu` (`menu_name`, `role`) VALUES ('member home', 'MEMBER');
INSERT INTO `sosvedu_apna`.`cy_menu` (`menu_name`, `role`) VALUES ('partner home', 'PARTNER');
INSERT INTO `sosvedu_apna`.`cy_menu` (`menu_name`, `role`) VALUES ('partner add branch', 'PARTNER');


