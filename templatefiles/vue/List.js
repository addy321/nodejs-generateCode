


module.exports = function(entityobj){
    var tool = require('../../utils/tool')
    // 所有字段拼接
    var columns = 'const columns = ['

    entityobj.fields.forEach(fieldObje => {
    // 获取类型
        columns += `
    { title: '${fieldObje.字段说明}', dataIndex: '${tool.toHump(fieldObje.字段名)}'},`
    })
    columns += `
    { title: '操作', dataIndex: 'action', scopedSlots: { customRender: 'action' } }
]`

        return `
<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="hanldleAdd()">新建</a-button>
      <a-button
        type="primary"
        icon="minus"
        @click="handleDelete(selectedRowKeys)"
        :disabled="!hasSelected()"
        :loading="loading"
      >删除</a-button>
    </div>

    <div class="table-page-search-wrapper">
      <a-form layout="inline">
        <a-row :gutter="48">
          <a-col :md="6" :sm="24">
            <a-form-item label="关键字">
              <a-input v-model="queryParam.keyword" placeholder />
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="24">
            <a-button type="primary" @click="() => {this.pagination.current = 1; this.getDataList()}">查询</a-button>
            <a-button style="margin-left: 8px" @click="() => (queryParam = {})">重置</a-button>
          </a-col>
        </a-row>
      </a-form>
    </div>

    <a-table
      ref="table"
      :columns="columns"
      :rowKey="row => row.${entityobj.idobj.字段名}"
      :dataSource="data"
      :pagination="pagination"
      :loading="loading"
      @change="handleTableChange"
      :rowSelection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
      :bordered="true"
      size="small"
    >
      <span slot="action" slot-scope="text, record">
        <template>
          <template>
            <a @click="handleEdit(record.${entityobj.idobj.字段名})">编辑</a>
            <a-divider type="vertical" />
          </template>
          <a @click="handleDelete([record.${entityobj.idobj.字段名}])">删除</a>
        </template>
      </span>
    </a-table>

    <edit-form ref="editForm" :afterSubmit="getDataList"></edit-form>
  </a-card>
</template>

<script>
import EditForm from './EditForm'

${columns}
export default {
  components: {
    EditForm
  },
  mounted() {
    this.getDataList()
  },
  data() {
    return {
      data: [],
      pagination: {
        current: 1,
        pageSize: 10,
        showTotal: (total, range) => '总数:'+total+'当前:'+range[0]+'-'+range[1]
      },
      filters: {},
      sorter: { field: '${entityobj.idobj.字段名}', order: 'asc' },
      loading: false,
      columns,
      queryParam: {},
      visible: false,
      selectedRowKeys: []
    }
  },
  methods: {
    handleTableChange(pagination, filters, sorter) {
      this.pagination = { ...pagination }
      this.filters = { ...filters }
      this.sorter = { ...sorter }
      this.getDataList()
    },
    getDataList() {
      this.selectedRowKeys = []

      this.loading = true
      this.$http
        .post('/${entityobj.package}/${entityobj.className}/GetDataList', {
          PageIndex: this.pagination.current,
          PageRows: this.pagination.pageSize,
          SortField: this.sorter.field || '${entityobj.idobj.字段名}',
          SortType: this.sorter.order,
          Search: this.queryParam,
          ...this.filters
        })
        .then(resJson => {
          this.loading = false
          this.data = resJson.Data
          const pagination = { ...this.pagination }
          pagination.total = resJson.Total
          this.pagination = pagination
        })
    },
    onSelectChange(selectedRowKeys) {
      this.selectedRowKeys = selectedRowKeys
    },
    hasSelected() {
      return this.selectedRowKeys.length > 0
    },
    hanldleAdd() {
      this.$refs.editForm.openForm()
    },
    handleEdit(${entityobj.idobj.字段名}) {
      this.$refs.editForm.openForm(${entityobj.idobj.字段名})
    },
    handleDelete(ids) {
      var thisObj = this
      this.$confirm({
        title: '确认删除吗?',
        onOk() {
          return new Promise((resolve, reject) => {
            thisObj.submitDelete(ids, resolve, reject)
          }).catch(() => console.log('Oops errors!'))
        }
      })
    },
    submitDelete(ids, resolve, reject) {
      this.$http.post('/${entityobj.package}/${entityobj.className}/DeleteData', ids).then(resJson => {
        resolve()
        if (resJson.Success) {
          this.$message.success('操作成功!')
          this.selectedRowKeys = []
          this.getDataList()
        } else {
          this.$message.error(resJson.Msg)
        }
      })
    }
  }
}
</script>
        `

}
