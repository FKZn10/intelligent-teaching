<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-edit"></i> 学生课程
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column label="选课Id" prop="studentCourseId" />
          <el-table-column label="课程名" prop="courseName" />
          <el-table-column label="教师" prop="teacherName" />
          <el-table-column label="学分" prop="credit" />
          <el-table-column align="center" label="操作" width="200px">
            <template slot-scope="scope">
              <el-button
                @click="deleteItem(scope.row.studentCourseId)"
                size="mini"
                type="danger"
                :disabled="isButtonDisabled"
                >退选
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/student/course";
import * as OptionApi from "@/api/option";

export default {
  name: "StudentCourse",
  data() {
    return {
      tableData: [],
      isButtonDisabled: true
    };
  },
  methods: {
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    },
    deleteItem(studentCourseId) {
      api.deleteItem(studentCourseId).then(() => {
        this.$message.success("退选成功!");
        this.getList();
      });
    },
    getSelectAndGradeStatus() {
      OptionApi.getAllowStudentSelect().then(res => {
        this.isButtonDisabled = !res;
      });
    }
  },
  created() {
    this.getList();
    this.getSelectAndGradeStatus();
  }
};
</script>

<style scoped></style>
