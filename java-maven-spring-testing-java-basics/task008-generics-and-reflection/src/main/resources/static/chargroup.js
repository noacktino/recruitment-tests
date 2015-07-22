function CharGroupController($scope, $http) {

    $scope.ungrouped = "hello";

    $scope.group = function () {
        $http.get('/group?chars=' + $scope.ungrouped).success(function (data) {
            $scope.grouped = data;
        })
    };

    $scope.group();
}